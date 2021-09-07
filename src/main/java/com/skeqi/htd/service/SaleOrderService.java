package com.skeqi.htd.service;

import com.skeqi.htd.controller.vo.QueryVO;
import com.skeqi.htd.po.entity.SaleOrder;

import java.util.List;

/**
 * 销售订单服务
 *
 * @author linkin
 */
public interface SaleOrderService {
	/**
	 * 根据条件查询订单列表
	 *
	 * @param vo
	 * @return
	 */
	List<SaleOrder> queryBy(QueryVO.QuerySaleOrdersVO vo);

	/**
	 * 创建销售订单，一笔销售订单按照产品+规格拆分多比子订单，子订单号唯一
	 *
	 * @param entities
	 */
	void createOrders(List<SaleOrder> entities);

	/**
	 * 更新订单审核状态
	 *
	 * @param exOrderNo
	 * @param auditState
	 * @return
	 */
	int updateAuditStateByExOrderNo(String exOrderNo, String auditState);
}
