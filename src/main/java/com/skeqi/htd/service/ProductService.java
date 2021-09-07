package com.skeqi.htd.service;

import com.skeqi.htd.po.entity.Product;

import java.util.List;

/**
 * 产品信息服务
 *
 * @author linkin
 */
public interface ProductService {
	/**
	 * 根据数据库id获取产品信息
	 *
	 * @param ids
	 * @return
	 */
	List<Product> getProductByIds(List<Integer> ids);
}
