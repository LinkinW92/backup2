package com.skeqi.htd.common;

import lombok.Getter;

/**
 * 审核状态
 *
 * @author linkin
 */
@Getter
public enum AuditState {
	DRAFT("草稿"),
	TO_AUDIT("待审批"),
	PASS("审批通过"),
	REJECT("已驳回"),
	DELETED("已作废");

	private String description;

	AuditState(String description) {
		this.description = description;
	}
}
