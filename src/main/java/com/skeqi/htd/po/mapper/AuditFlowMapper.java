package com.skeqi.htd.po.mapper;

import com.skeqi.htd.po.entity.AuditFlow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 审核流水mapper
 *
 * @author linkin
 */
@Mapper
public interface AuditFlowMapper {
	/**
	 * 根据订单号获取最近的一条操作记录
	 *
	 * @param exOrderNo
	 * @param orderType
	 * @return
	 */
	AuditFlow getLatestFlow(@Param("exOrderNo") String exOrderNo, @Param("orderType") String orderType);


	/**
	 * 创建审核流水
	 *
	 * @param af
	 * @return
	 */
	int createAuditFlow(@Param("af") AuditFlow af);
}
