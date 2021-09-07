package com.skeqi.htd.po.entity;

import lombok.Data;

/**
 * 供应商信息
 *
 * @author linkin
 */
@Data
public class Supplier extends Entity {
	private String name;
	private String type;
	private String code;
	/**
	 * 对应采购员
	 */
	private Integer relativePurchaserId;
	private String relativePurchaser;
	/**
	 * 联系人
	 */
	private String contact;
	/**
	 * 联系人手机和电话
	 */
	private String contactMobile;
	private String contactTel;
	/**
	 * 联系人地址
	 */
	private String contactAddress;
}
