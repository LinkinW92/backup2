package com.skeqi.htd.common;

import lombok.Getter;

/**
 * 采购单、销售单状态
 *
 * @author linkin
 */
@Getter
public enum OrderState {

	RUNNING("进行中"),
	FINISHED("已结束"),

	/**
	 * 采购单状态
	 */
	TO_STOCK("待入库"),
	STOCKED("入库"),
	REJECT_STOCK("采购单退货"),
	/**
	 * 销售单状态
	 */
	TO_EX_WARESOUSE("待出库"),
	EX_WARESOUSE("出库"),
	REJECT_EX("销售单退货");


	private String description;

	OrderState(String description) {
		this.description = description;
	}
}
