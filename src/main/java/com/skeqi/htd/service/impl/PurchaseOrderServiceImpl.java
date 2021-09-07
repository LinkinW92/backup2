package com.skeqi.htd.service.impl;

import com.skeqi.htd.common.BizException;
import com.skeqi.htd.controller.vo.QueryVO;
import com.skeqi.htd.po.entity.PurchaseOrder;
import com.skeqi.htd.po.mapper.PurchaseOrderMapper;
import com.skeqi.htd.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购订单服务
 *
 * @author linkin
 */
@Service("htdPurchaseOrderServiceImpl")
@Slf4j
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	private final PurchaseOrderMapper mapper;

	@Autowired
	public PurchaseOrderServiceImpl(PurchaseOrderMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<PurchaseOrder> queryBy(QueryVO.QueryPurchaserOrdersVO vo) {
		return this.mapper.listOrdersBy(vo);
	}

	@Override
	public void createOrders(List<PurchaseOrder> entities) {
		if (CollectionUtils.isEmpty(entities)) {
			return;
		}
		// TODO 产品信息校验
		try {
			this.mapper.createOrders(entities);
		} catch (Exception e) {
			log.warn("创建采购订单失败:{}", e);
			throw new BizException("创建采购订单失败");
		}
	}

	@Override
	public int updateAuditStateByExOrderNo(String exOrderNo, String auditState) {
		return this.mapper.updateAuditStateByExOrderNo(exOrderNo, auditState);
	}
}
