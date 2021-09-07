package com.skeqi.htd.po.entity;

import lombok.Data;

/**
 * 产品信息
 *
 * @author linkin
 */
@Data
public class Product extends Entity {
	/**
	 * 产品编码
	 */
	private String code;
	/**
	 * 产品规格 stock keeping unit
	 */
	private String sku;
	/**
	 * 产品名称
	 */
	private String name;
	/**
	 * 品牌
	 */
	private String brand;
	/**
	 * 图片
	 */
	private String picture;

	/**
	 * 产品单位， 个、块
	 */
	private String unit;
}
