package com.skeqi.htd.po.mapper;

import com.skeqi.htd.po.entity.ValveConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 审批流阀门配置
 *
 * @author linkin
 */
@Mapper
public interface ValveConfigMapper {
	/**
	 * 根据订单类型，查询审批流阀门
	 *
	 * @param orderType
	 * @return
	 */
	List<ValveConfig> getValvesByOrderType(@Param("orderType") String orderType);

}
