package com.skeqi.htd.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 断言
 *
 * @author qingwei
 */
public class Asserts {

    public static void notNull(Object o, String message) {
        if (o == null) {
            throw new BizException(message);
        }
    }

    public static void notEmpty(String s, String message) {
        if (StringUtils.isEmpty(s)) {
            throw new BizException(message);
        }
    }

    public static void checkArgs(Boolean expression, String message) {
        if (!expression) {
            throw new BizException(message);
        }
    }
}
