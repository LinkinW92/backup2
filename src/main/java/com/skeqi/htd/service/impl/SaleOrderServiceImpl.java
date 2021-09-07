package com.skeqi.htd.service.impl;

import com.skeqi.htd.common.Asserts;
import com.skeqi.htd.common.BizException;
import com.skeqi.htd.controller.vo.QueryVO;
import com.skeqi.htd.po.entity.SaleOrder;
import com.skeqi.htd.po.mapper.SaleOrderMapper;
import com.skeqi.htd.service.SaleOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购单service
 *
 * @author linkin
 */
@Service
@Slf4j
public class SaleOrderServiceImpl implements SaleOrderService {
	private final SaleOrderMapper mapper;

	@Autowired
	public SaleOrderServiceImpl(SaleOrderMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<SaleOrder> queryBy(QueryVO.QuerySaleOrdersVO vo) {
		Asserts.notNull(vo, "无效的订单查询条件");
		return mapper.listOrdersBy(vo);
	}

	@Override
	public void createOrders(List<SaleOrder> entities) {
		if (CollectionUtils.isEmpty(entities)) {
			return;
		}
		// TODO 产品信息校验
		try {
			this.mapper.createOrders(entities);
		} catch (Exception e) {
			log.warn("创建销售订单失败:{}", e);
			throw new BizException("创建销售订单失败");
		}
	}

	@Override
	public int updateAuditStateByExOrderNo(String exOrderNo, String auditState) {
		return this.mapper.updateAuditStateByExOrderNo(exOrderNo, auditState);
	}
}
