package com.ljq.common.ret;


/**
 * @author : lijq
 * @date : 2020/3/28 9:50
 */
public enum ResultCode implements IErrorCode {
    /**
     *
     */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),

    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    UNREGISTER(10002, "用户未注册"),
    VALIDATE_FAILED(10003, "参数检验失败"),

    ORDER_FAILED(20001,"订单未支付或其他状态");
    private Integer code;
    private String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return message;
    }
}