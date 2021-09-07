package com.skeqi.htd.common;

/**
 * 接口返回码
 *
 * @author qingwei
 */
public enum ResultCode {
	SUCCESS(0, "成功"),
	BIZ_EXCEPTION(-1, "业务异常"),
	ILLEGAL_ARGUMENTS(-2, "非法参数"),
	SYSTEM_DEFECT(-3, "系统缺陷"),
	UN_AUTHORIZED(-4, "无权限操作");


	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

}
