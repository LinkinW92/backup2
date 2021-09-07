package com.skeqi.htd.service.impl;

import com.skeqi.htd.common.Asserts;
import com.skeqi.htd.po.entity.Customer;
import com.skeqi.htd.po.mapper.CustomerMapper;
import com.skeqi.htd.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户信息管理
 *
 * @author linkin
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	private final CustomerMapper mapper;

	@Autowired
	public CustomerServiceImpl(CustomerMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Asserts.notNull(customerId, "无效的客户id");
		return mapper.getCustomerById(customerId);
	}

	@Override
	public List<Customer> getCustomersByName(String customer) {
		Asserts.notEmpty(customer, "未指定客户名称");
		return mapper.getCustomersByName(customer);
	}

	@Override
	public List<String> getAllCustomerNames() {
		return mapper.getAllCustomerNames();
	}
}
