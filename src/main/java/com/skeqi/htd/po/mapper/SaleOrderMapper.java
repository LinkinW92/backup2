package com.skeqi.htd.po.mapper;


import com.skeqi.htd.controller.vo.QueryVO;
import com.skeqi.htd.po.entity.SaleOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售订单mapper
 *
 * @author linkin
 */
@Mapper
public interface SaleOrderMapper {
	/**
	 * 按条件查询订单
	 *
	 * @param vo
	 * @return
	 */
	List<SaleOrder> listOrdersBy(@Param("vo") QueryVO.QuerySaleOrdersVO vo);

	/**
	 * 创建销售订单
	 *
	 * @param entities
	 */
	void createOrders(@Param("list") List<SaleOrder> entities);

	/**
	 * 更新订单审核状态
	 *
	 * @param exOrderNo
	 * @param auditState
	 * @return
	 */
	int updateAuditStateByExOrderNo(String exOrderNo, String auditState);
}
