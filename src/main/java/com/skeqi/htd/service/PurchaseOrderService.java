package com.skeqi.htd.service;

import com.skeqi.htd.controller.vo.QueryVO;
import com.skeqi.htd.po.entity.PurchaseOrder;

import java.util.List;

/**
 * 采购单服务
 *
 * @author linkin
 */
public interface PurchaseOrderService {
	/**
	 * 根据条件查询采购订单
	 *
	 * @param vo
	 * @return
	 */
	List<PurchaseOrder> queryBy(QueryVO.QueryPurchaserOrdersVO vo);

	/**
	 * 创建采购订单，一笔销售订单按照产品+规格拆分多比子订单，子订单号唯一
	 *
	 * @param toEntities
	 */
	void createOrders(List<PurchaseOrder> toEntities);

	/**
	 * 更新订单审核状态
	 *
	 * @param exOrderNo
	 * @param auditState
	 * @return
	 */
	int updateAuditStateByExOrderNo(String exOrderNo, String auditState);
}
