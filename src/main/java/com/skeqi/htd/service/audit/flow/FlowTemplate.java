package com.skeqi.htd.service.audit.flow;

import com.skeqi.htd.po.entity.ValveConfig;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 流程模板,流程模板中有多个阀门{@link Valve}, 多个阀门按顺序排好，按顺序执行
 *
 * @author linkin
 */
@Data
public class FlowTemplate {
	/**
	 * 模板id
	 */
	private Integer templateId;
	/**
	 * 流程作用的单据类型
	 */
	private String orderType;
	/**
	 * 阀门
	 */
	private List<Valve> valves;

	/**
	 * 根据流程配置，构建出审批流模板
	 *
	 * @param list
	 * @return
	 */
	public static FlowTemplate build(List<ValveConfig> list) {
		FlowTemplate template = new FlowTemplate();
		template.setTemplateId(list.get(0).getTemplateId());
		template.setOrderType(list.get(0).getOrderType());
		template.setValves(list.parallelStream()
			.filter(Objects::nonNull)
			.map(Valve::build)
			.collect(Collectors.toList())
		);
		return template;
	}

	public Valve firstValve() {
		return this.valves.parallelStream().min(Comparator.comparing(Valve::getOrder)).get();
	}

	public Valve lastValve() {
		return this.valves.parallelStream().max(Comparator.comparing(Valve::getOrder)).get();
	}

	public Valve nextValve(Integer order) {
		return this.valves.parallelStream().filter(e -> e.getOrder() > order).min(Comparator.comparing(Valve::getOrder)).get();
	}

	public Valve getById(Integer valveId) {
		Optional<Valve> opt = this.valves.parallelStream().filter(e -> e.getValveId().intValue() == valveId).findFirst();
		return opt.isPresent() ? opt.get() : null;
	}
}
