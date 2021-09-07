package com.skeqi.htd.util;

import com.skeqi.htd.po.entity.ValveConfig;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 由java对象生成sql语句
 *
 * @author linkin
 */
public class SqlGenerator {

	public static Map<String, String> javaProperty2SqlColumnMap = new HashMap<>();

	static {
		javaProperty2SqlColumnMap.put("Integer", "INTEGER");
		javaProperty2SqlColumnMap.put("Short", "tinyint");
		javaProperty2SqlColumnMap.put("Long", "bigint");
		javaProperty2SqlColumnMap.put("BigDecimal", "decimal(19,2)");
		javaProperty2SqlColumnMap.put("Double", "double precision not null");
		javaProperty2SqlColumnMap.put("Float", "float");
		javaProperty2SqlColumnMap.put("Boolean", "bit");
		javaProperty2SqlColumnMap.put("Timestamp", "datetime");
		javaProperty2SqlColumnMap.put("String", "VARCHAR(255)");
		javaProperty2SqlColumnMap.put("LocalDateTime", "datetime");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class clz = ValveConfig.class;
		createTable(clz, null);
		selectTable(clz);
	}

	public static void createTable(Class obj, String tableName) {
		Field[] fields;
		fields = obj.getDeclaredFields();
		String param;
		String column;
		StringBuilder sb;
		sb = new StringBuilder(50);
		if (tableName == null || tableName.equals("")) {
			tableName = obj.getName();
			tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		}
		sb.append("create table t").append(camelToUnderline(tableName)).append(" ( \r\n");
		sb.append("id int NOT NULL AUTO_INCREMENT COMMENT '主键id',\n");
		for (Field f : fields) {
			column = f.getName();
			if (column.equals("serialVersionUID")) {
				continue;
			}
			column = camelToUnderline(column);
			param = f.getType().getSimpleName();
			sb.append(column);
			sb.append(" ").append(javaProperty2SqlColumnMap.get(param)).append(" ");
			sb.append(" comment '',\n ");
		}
		sb.append("deleted tinyint(1) NOT NULL DEFAULT '0' comment '删除标识，0未删除，1删除',\n" +
			"  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',\n" +
			"  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment '更新时间',\n" +
			"  PRIMARY KEY (id)\n");
		sb.append(")ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci comment '';");
		System.out.println("\n\n" + sb.toString());
	}

	public static void selectTable(Class obj) {
		StringBuilder sb = new StringBuilder("\n\n\nselect id as id,\n ");
		for (Field field : obj.getDeclaredFields()) {
			sb.append(camelToUnderline(field.getName()) + " as " + field.getName() + ",\n");
		}
		sb.append("create_time as createTime,\n update_time as updateTime");
		sb.append("\n from t" + camelToUnderline(obj.getSimpleName())).append("\n where deleted=0;");
		System.out.println(sb.toString());
	}

	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append("_");
			}
			sb.append(Character.toLowerCase(c));
		}
		return sb.toString();
	}

}
