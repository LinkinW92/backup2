package com.skeqi.htd.common;

import lombok.Getter;

/**
 * 订单类型
 *
 * @author linkin
 */
@Getter
public enum OrderType {
	PURCHASE("采购订单"), SALE("销售订单");

	private String description;

	OrderType(String description) {
		this.description = description;
	}
}
