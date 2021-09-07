package com.skeqi.htd.service.audit.flow;

import com.skeqi.htd.po.entity.ValveConfig;
import lombok.Data;

/**
 * 审批流中的一个步骤，即阀门
 *
 * @author linkin
 */
@Data
public class Valve {

	private Integer valveId;
	/**
	 * 展示名称，如一级审批人
	 */
	private String valveName;
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

	public static Valve build(ValveConfig c) {
		Valve v = new Valve();
		v.setValveId(c.getId());
		v.setAuditor(c.getAuditor());
		v.setAuditorId(c.getAuditorId());
		v.setDept(c.getDept());
		v.setOrder(c.getOrder());
		v.setValveName(c.getName());
		return v;
	}
}
