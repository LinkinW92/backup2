package com.skeqi.htd.service;

import com.skeqi.htd.po.entity.Customer;

import java.util.List;

/**
 * 客户信息管理
 *
 * @author linkin
 */
public interface CustomerService {

	/**
	 * 根据数据库主键获取客户信息
	 *
	 * @param customerId
	 * @return
	 */
	Customer getCustomerById(Integer customerId);

	/**
	 * 根据客户名称获取客户信息列表，一个客户下可能有多个联系人
	 *
	 * @param customer
	 * @return
	 */
	List<Customer> getCustomersByName(String customer);

	/**
	 * 获取所有的客户名称
	 *
	 * @return
	 */
	List<String> getAllCustomerNames();
}
