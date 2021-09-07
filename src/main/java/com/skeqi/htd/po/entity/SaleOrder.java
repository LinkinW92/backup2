package com.skeqi.htd.po.entity;

import lombok.Data;

/**
 * 销售订单
 *
 * @author linkin
 */
@Data
public class SaleOrder extends CommonOrder {
	/**
	 * 客户信息，对应customer表的主键id
	 */
	private Integer customerId;
	private String customer;
	/**
	 * 销售
	 */
	private String seller;
	private Integer sellerId;
}
