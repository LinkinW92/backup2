package com.skeqi.htd.common;

import lombok.Data;

/**
 * 结果包装类
 *
 * @param <T>
 * @author linkin
 */
@Data
public class Result<T> {
	private T data;
	private Integer code;
	private String message;

	public static <T> Result succeed(T data) {
		Result r = new Result();
		r.setData(data);
		r.setCode(ResultCode.SUCCESS.getCode());
		r.setMessage(null);
		return r;
	}

	public static Result fail(ResultCode rc) {
		Result r = new Result();
		r.setData(null);
		r.setCode(rc.getCode());
		r.setMessage(rc.getMessage());
		return r;
	}

	public static Result fail(String message) {
		Result r = new Result();
		r.setData(null);
		r.setCode(ResultCode.BIZ_EXCEPTION.getCode());
		r.setMessage(message);
		return r;
	}
}
