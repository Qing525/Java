package com.ljq.common.ret;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : lijq
 * @date : 2020/4/4 16:43
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> failed(IErrorCode errorCode) {
        return new Result<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> Result<T> failed(String message) {
        return new Result<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> Result<T> failed(IErrorCode errorCode, T data) {
        return new Result<T>(errorCode.getCode(), errorCode.getMessage(), data);
    }
}
