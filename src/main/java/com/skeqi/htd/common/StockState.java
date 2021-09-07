package com.skeqi.htd.common;

import lombok.Getter;

/**
 * 入库状态
 *
 * @author linkin
 */
@Getter
public enum StockState {
	/**
	 * 采购单入库状态
	 */
	NONE_IN("未入库"),

	PART_IN("部分入库"),

	ALL_IN("完全入库"),
	/**
	 * 销售单出库状态
	 */
	NONE_OUT("未出库"),

	PART_OUT("部分出库"),

	ALL_OUT("完全出库");

	private String description;

	StockState(String description) {
		this.description = description;
	}
}
