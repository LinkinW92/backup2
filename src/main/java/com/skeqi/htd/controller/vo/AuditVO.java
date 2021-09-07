package com.skeqi.htd.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 订单审核操作
 *
 * @author linkin
 */
@Data
public class AuditVO {
	@ApiModelProperty("审核人")
	private String auditor;
	@ApiModelProperty("审核状态, 驳回 REJECT  或者 通过 PASS")
	private String auditState;
	@ApiModelProperty("外部订单号")
	private String exOrderNo;
	@ApiModelProperty("订单类型")
	private String orderType;
	@ApiModelProperty("备注")
	private String remark;
}
