package com.skeqi.htd.po.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单操作流水
 *
 * @author linkin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditFlow extends Entity {

	private String exOrderNo;
	private String orderType;
	private String auditState;
	/**
	 * 对应的流程模板和阀门ID
	 */
	private Integer templateId;
	private Integer valveId;
	/**
	 * 操作人信息
	 */
	private String auditor;
	private Integer auditorId;
	/**
	 * 操作内容, 对应阀门的名称
	 */
	private String valveName;
	private String remark;
}
