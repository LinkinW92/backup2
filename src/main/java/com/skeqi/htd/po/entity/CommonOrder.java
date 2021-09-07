package com.skeqi.htd.po.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 销售订单和采购订单的公共信息
 *
 * @author linkin
 */
@Data
public class CommonOrder extends Entity {
	/**
	 * 内部主订单号
	 */
	protected String orderNo;
	/**
	 * 内部子订单号
	 */
	protected String subOrderNo;
	/**
	 * 外部订单号
	 */
	protected String exOrderNo;
	/**
	 * 单据日期
	 */
	protected LocalDateTime orderTime;
	/**
	 * 交货日期
	 */
	protected LocalDateTime deliveryTime;
	/**
	 * 退单时间
	 */
	protected LocalDateTime cancelTime;
	/**
	 * 产品ID和产品名称
	 */
	protected Integer productId;
	protected String product;
	protected String brand;
	protected String productSku;
	/**
	 * 产品动态信息，产品ID关联产品的静态信息，动态信息主要有：采购单价，优惠率，优惠金额，分仓信息
	 */
	protected String productExt;

	/**
	 * 应收款(销售单) or 应付款(采购单)
	 */
	protected String dueAccount;
	/**
	 * 附件,多个附件逗号分割
	 */
	protected String materials;

	protected String orderState;
	protected String auditState;
	protected String stockState;
	protected String creator;

	/**
	 * 是否含税，根据订单得税率计算得出
	 */
	protected Boolean hasTax;
	protected String subWarehouse;
	/**
	 * 订单备注
	 */
	private String remark;
}
