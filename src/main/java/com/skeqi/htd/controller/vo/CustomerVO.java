package com.skeqi.htd.controller.vo;

import com.skeqi.htd.po.entity.Customer;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 客户信息
 *
 * @author linkin
 */
@Data
public class CustomerVO {
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


	public static CustomerVO toVO(Customer customer) {
		CustomerVO c = new CustomerVO();
		BeanUtils.copyProperties(customer, c);
		return c;
	}
}

