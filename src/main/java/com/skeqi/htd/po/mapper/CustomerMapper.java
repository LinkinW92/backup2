package com.skeqi.htd.po.mapper;

import com.skeqi.htd.po.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户信息管理mapper
 *
 * @author linkin
 */
@Mapper
public interface CustomerMapper {
	/**
	 * 根据数据库id获取用户信息
	 *
	 * @param id
	 * @return
	 */
	Customer getCustomerById(@Param("id") Integer id);

	/**
	 * 根据客户名称获取客户信息列表，一个客户下可能有多个联系人
	 *
	 * @param customer
	 * @return
	 */
	List<Customer> getCustomersByName(@Param("customer") String customer);

	/**
	 * 获取所有的客户名称
	 *
	 * @return
	 */
	List<String> getAllCustomerNames();
}
