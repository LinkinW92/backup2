package com.skeqi.htd.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 查询vo
 *
 * @author linkin
 */
@Data
public class QueryVO {
	private final static String ALL = "全部";
	private final Set<String> TIME_ENUM = new HashSet<>(Arrays.asList("今天", "昨天", "本周", "上周", "本月", "上月"));
	private final Set<String> STATE_ENUM = new HashSet<>(Arrays.asList("全部", "草稿", "待审批", "已提交", "已驳回", "审批通过", "已作废"));
	private final Set<String> ORDER_STATE_ENUM = new HashSet<>(Arrays.asList("全部", "执行中", "已结束"));

	@ApiModelProperty(value = "订单号")
	protected String exOrderNo;
	@ApiModelProperty("订单时间")
	protected String orderTime;
	@ApiModelProperty("交货时间")
	protected String deliveryTime;
	@ApiModelProperty("审核状态")
	protected String auditState;
	@ApiModelProperty("订单状态")
	protected String orderState;
	@ApiModelProperty("出库状态")
	protected String stockState;
	@ApiModelProperty("是否含税")
	protected Boolean hasTax;
	@ApiModelProperty("分仓")
	protected String subWarehouse;
	@ApiModelProperty("产品")
	protected String product;
	@ApiModelProperty("创建人")
	protected String creator;
	@ApiModelProperty("品牌")
	protected String brand;
	@ApiModelProperty("退单时间")
	protected String cancelTime;

	/**
	 * 将前端传入得中文语义转为代码层面得时间范围
	 */
	@ApiModelProperty(value = "订单时间", hidden = true)
	protected String[] orderTimeRange;
	@ApiModelProperty(value = "交货时间", hidden = true)
	protected String[] deliveryTimeRange;
	@ApiModelProperty(value = "退货时间", hidden = true)
	protected String[] cancelTimeRange;


	@Data
	public static class QueryPurchaserOrdersVO extends QueryVO {
		@ApiModelProperty("供应商")
		private String supplier;
		@ApiModelProperty("订单对应的采购人员")
		private String purchaser;

		public static QueryPurchaserOrdersVO with(String orderNo) {
			QueryPurchaserOrdersVO vo = new QueryPurchaserOrdersVO();
			vo.setExOrderNo(orderNo);
			return vo;
		}

	}

	@Data
	public static class QuerySaleOrdersVO extends QueryVO {
		@ApiModelProperty("客户")
		private String customer;
		@ApiModelProperty("订单对应的销售人员")
		private String seller;

		public static QuerySaleOrdersVO with(String orderNo) {
			QuerySaleOrdersVO vo = new QuerySaleOrdersVO();
			vo.setExOrderNo(orderNo);
			return vo;
		}
	}


	@SuppressWarnings("unused")
	public String[] getOrderTimeRange() {
		return transformTime2Range(this.orderTime);
	}

	@SuppressWarnings("unused")
	public String[] getDeliveryTimeRange() {
		return transformTime2Range(this.deliveryTime);
	}

	@SuppressWarnings("unused")
	public String[] getCancelTimeRange() {
		return transformTime2Range(this.cancelTime);
	}

	private static String[] transformTime2Range(String timeInChinese) {
		if (ALL.equals(timeInChinese) || null == timeInChinese) {
			return null;
		}
		LocalDate min = null, max = null;
		switch (timeInChinese) {
			case "今天":
				min = max = LocalDate.now();
				break;
			case "昨天":
				min = max = LocalDate.now().minusDays(1L);
				break;
			case "本周":
				min = LocalDate.now().with(DayOfWeek.MONDAY);
				max = LocalDate.now().with(DayOfWeek.SUNDAY);
				break;
			case "上周":
				min = LocalDate.now().with(DayOfWeek.MONDAY).minusDays(7L);
				max = LocalDate.now().with(DayOfWeek.SUNDAY).minusDays(7L);
				break;
			case "本月":
				min = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
				max = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
				break;
			case "上月":
				LocalDate pivot = LocalDate.now().minusMonths(1L);
				min = pivot.with(TemporalAdjusters.firstDayOfMonth());
				max = pivot.with(TemporalAdjusters.lastDayOfMonth());
				break;
			default:
				if (!StringUtils.isEmpty(timeInChinese)) {
					final String[] timeRange = timeInChinese.split("_");
					if (null != timeRange && timeRange.length == 2) {
						try {
							final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							min = LocalDate.parse(timeRange[0], dateFormatter);
							max = LocalDate.parse(timeRange[1], dateFormatter);
						} catch (Exception e) {
							// ignore this
						}
					}
				}
		}
		if (null != min && null != max) {
			final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			System.out.println(timeInChinese + ":" + min.atTime(LocalTime.MIN).format(dateTimeFormatter) + "||" + max.atTime(LocalTime.MAX).format(dateTimeFormatter));
			return new String[]{min.atTime(LocalTime.MIN).format(dateTimeFormatter), max.atTime(LocalTime.MAX).format(dateTimeFormatter)};
		}
		return null;
	}
}
