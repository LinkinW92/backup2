package com.skeqi.htd.common;

import com.google.common.base.Joiner;

import java.time.format.DateTimeFormatter;

/**
 * 常量定义
 *
 * @author linkin
 */
public interface Constants {
	String BASE_API = "/htm";
	String API_VERSION = "/V1";

	Joiner JOINER = Joiner.on("_"), COMMA_JOINER = Joiner.on(",");

	DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
}
