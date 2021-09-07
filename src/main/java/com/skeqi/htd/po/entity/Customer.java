package com.skeqi.htd.po.entity;

import lombok.Data;

/**
 * 客户信息
 *
 * @author linkin
 */
@Data
public class Customer extends Entity {
	/**
	 * 客户名称
	 */
	private String name;
	/**
	 * 客户编码
	 */
	private String code;
	/**
	 * 客户类型
	 */
	private String type;
	/**
	 * 关联销售(公司内部销售)
	 */
	private String relativeSeller;
	/**
	 * 客户联系人
	 */
	private String contact;
	/**
	 * 客户联系人电话
	 */
	private String contactMobile;
	private String contactTel;
	/**
	 * 客户联系人地址
	 */
	private String contactAddress;
}
