package com.skeqi.htd.po.mapper;

import com.skeqi.htd.po.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 供应商持久层
 *
 * @author linkin
 */
@Mapper
public interface SupplierMapper {

	/**
	 * 根据id查询
	 *
	 * @param id
	 * @return
	 */
	Supplier getSupplierById(@Param("id") Integer id);

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
	List<Supplier> getSuppliersByName(@Param("supplierName") String supplierName);
}
