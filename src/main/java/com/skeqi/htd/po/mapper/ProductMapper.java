package com.skeqi.htd.po.mapper;

import com.skeqi.htd.po.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品信息持久层
 *
 * @author linkin
 */
@Mapper
public interface ProductMapper {
	/**
	 * 根据id获取产品信息
	 *
	 * @param ids
	 * @return
	 */
	List<Product> getProductByIds(@Param("ids") List<Integer> ids);
}
