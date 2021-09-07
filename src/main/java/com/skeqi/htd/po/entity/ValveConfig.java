package com.skeqi.htd.po.entity;

import lombok.Data;

/**
 * 流程阀门配置
 *
 * @author linkin
 */
@Data
public class ValveConfig extends Entity {
	private Integer templateId;
	private String orderType;
	private String name;
	/**
	 * 审核人
	 */
	private String auditor;
	/**
	 * 审核人id
	 */
	private Integer auditorId;
	/**
	 * 阀门在整个流程中的位置
	 */
	private Integer order;
	/**
	 * 审核人对应的部门
	 */
	private String dept;
}
