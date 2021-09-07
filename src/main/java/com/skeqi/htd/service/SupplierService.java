package com.skeqi.htd.service;

import com.skeqi.htd.po.entity.Supplier;

import java.util.List;

/**
 * 供应商服务
 *
 * @author linkin
 */
public interface SupplierService {
	/**
	 * 根据数据库id查询供应商信息
	 *
	 * @param supplierId
	 * @return
	 */
	Supplier getSupplierById(Integer supplierId);

	/**
	 * 获取所有的供应商名称
	 *
	 * @return
	 */
	List<String> getAllSupplierNames();

	/**
	 * 获取对应供应商的联系信息
	 *
	 * @param supplierName
	 * @return
	 */
	List<Supplier> getSuppliersByName(String supplierName);
}
