package com.skeqi.htd.po.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 数据模型基类，所有的表设计都要有这几个字段
 *
 * @author linkin
 */
@Data
public class Entity {
	protected Integer id;
	protected boolean deleted;
	protected LocalDateTime createTime;
	protected LocalDateTime updateTime;
}
