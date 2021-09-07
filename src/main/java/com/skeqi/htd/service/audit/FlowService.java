package com.skeqi.htd.service.audit;

import com.skeqi.htd.common.*;
import com.skeqi.htd.po.entity.AuditFlow;
import com.skeqi.htd.po.entity.ValveConfig;
import com.skeqi.htd.po.mapper.AuditFlowMapper;
import com.skeqi.htd.po.mapper.ValveConfigMapper;
import com.skeqi.htd.service.audit.flow.FlowTemplate;
import com.skeqi.htd.service.audit.flow.Valve;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * （审批）流程服务
 * 1.每经过一个阀门，都会产生一条流水记录
 * 2.从当前处理的阀门，可以推出下一个需要处理的阀门
 * 流程触发时机：
 * 1.销售/采购订单生成后，自动绑定一个流程模板
 * 2.当前阀门逻辑处理完成后，若非终止状态，更新到下一级阀门，并推消息给下一级阀门的审核人
 *
 * @author linkin
 * @apiNote 当前版本中，即htm.version = 1.0.0时，一种订单类型只对应一个流程模板，后期有
 * 业务需要再拓展称一对多的模式。
 */
@Service
@Slf4j
public class FlowService {

	private final AuditFlowMapper mapper;
	private final ValveConfigMapper configMapper;

	@Autowired
	public FlowService(AuditFlowMapper mapper, ValveConfigMapper configMapper) {
		this.mapper = mapper;
		this.configMapper = configMapper;
	}

	/**
	 * 创建订单时，创建对应的流程。这一步只是记录流程的初始化信息，即往数据库中存储一条初始阀门。
	 *
	 * @param exOrderNo
	 * @param type
	 */
	public void initialize(String exOrderNo, OrderType type) {
		Asserts.notEmpty(exOrderNo, "订单号不可为空");
		Asserts.notNull(type, "订单类型不可为空");
		final FlowTemplate template = this.getTemplateByOrderType(type.name());
		if (null == template) {
			throw new BizException("未获取到对应订单类型的流程模板");
		}
		this.mapper.createAuditFlow(AuditFlow.builder()
			.exOrderNo(exOrderNo)
			.orderType(type.name())
			.valveName("初始系统默认阀门")
			.valveId(0)
			.templateId(template.getTemplateId())
			.build()
		);
	}


	private FlowTemplate getTemplateByOrderType(String orderType) {
		List<ValveConfig> list = this.configMapper.getValvesByOrderType(orderType);
		if (CollectionUtils.isEmpty(list)) {
			throw new BizException("未找到对应订单类型的流程模板配置");
		}
		return FlowTemplate.build(list);
	}

	/**
	 * 该方法在审核成功后进行调用
	 * 校验当前审核流程是否已经到最后一个阀门，如果不是最后一个阀门, 则将当前阀门下推一个
	 *
	 * @param exOrderNo
	 * @param orderType
	 * @return
	 */
	public boolean checkLastValve(String exOrderNo,
								  String orderType,
								  String auditor,
								  String remark) {
		Asserts.checkArgs(!StringUtils.isEmpty(exOrderNo) && !StringUtils.isEmpty(orderType), "未指定订单号和订单类型");
		AuditFlow currentFlow = this.mapper.getLatestFlow(exOrderNo, orderType);
		if (null == currentFlow) {
			// 流程一般都会先通过initial方法进行初始化，一般地，这里不为空。为空表示出bug了
			throw new BizException(ResultCode.SYSTEM_DEFECT);
		}

		FlowTemplate template = this.getTemplateByOrderType(orderType);
		Valve currentValve = template.getById(currentFlow.getValveId());
		if (null == currentValve) {
			throw new BizException(ResultCode.SYSTEM_DEFECT);
		}

		Valve next = template.nextValve(currentValve.getOrder());

		if (!next.getAuditor().equals(auditor)) {
			throw new BizException(ResultCode.UN_AUTHORIZED);
		}

		this.mapper.createAuditFlow(AuditFlow.builder()
			.auditState(AuditState.PASS.name())
			.templateId(template.getTemplateId())
			.exOrderNo(exOrderNo)
			.auditor(auditor)
			.auditorId(null)
			.orderType(orderType)
			.remark(remark)
			.valveId(next.getValveId())
			.valveName(next.getValveName()).build());

		// 判断是否可以将订单审核状态更新为审核通过
		return Objects.equals(next.getOrder().intValue(), template.lastValve().getOrder());
	}
}
