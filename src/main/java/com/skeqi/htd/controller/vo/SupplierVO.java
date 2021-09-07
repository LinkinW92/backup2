package com.skeqi.htd.controller.vo;

import com.skeqi.htd.po.entity.Supplier;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 供应商信息
 *
 * @author linkin
 */
@Data
public class SupplierVO {
	private String name;
	private String type;
	private String code;
	/**
	 * 对应采购员
	 */
	private Integer relativePurchaserId;
	private String relativePurchaser;
	/**
	 * 联系人
	 */
	private String contact;
	/**
	 * 联系人手机和电话
	 */
	private String contactMobile;
	private String contactTel;
	/**
	 * 联系人地址
	 */
	private String contactAddress;

	public static SupplierVO toVO(Supplier supplier) {
		SupplierVO s = new SupplierVO();
		BeanUtils.copyProperties(supplier, s);
		return s;
	}
}
