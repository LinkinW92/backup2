package com.skeqi.htd.common;

/**
 * 业务异常
 *
 * @author qingwei
 */
public class BizException extends RuntimeException {

    private String message;
    private Integer code = -1;


    public BizException() {
    }

    public BizException(String message) {
        super(message);
        this.message = message;
    }

    public BizException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.message = resultCode.getMessage();
        this.code = resultCode.getCode();
    }

    public static BizException from(String format, Object... parameters) {
        String msg = String.format(format, parameters);
        return new BizException(msg);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
