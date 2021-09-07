package com.skeqi.htd.service.audit.flow;


import lombok.Data;

/**
 * 审核记录
 *
 * @author linkin
 */
@Data
public class AuditRecord {
	/**
	 * 订单号
	 */
	private String orderNo;
	/**
	 * 订单类型
	 */
	private String orderType;
	/**
	 * 审核人
	 */
	private String auditor;
	/**
	 * 审核人id
	 */
	private Integer auditorId;
	/**
	 * 审核状态
	 */
	private String auditState;
	/**
	 * 备注，如果是审核拒绝，可能需要填写拒绝原因
	 */
	private String remark;
	/**
	 * 对应的阀门id
	 */
	private Integer valveId;
}
