package com.ljq.tool.utils;

public enum ResponseCode {
    /**
     *     返回成功
     */
    SUCCESS(200);

    private final int value;

    private ResponseCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
