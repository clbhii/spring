package com.cl.jpa.core.common;

import lombok.AllArgsConstructor;

/**
 * by cl at 2020/7/2 0002
 */
@AllArgsConstructor
public enum ErrorCode implements BaseErrorCode {

    SUCCESS("8200", "成功"),
    INTERNAL_SERVER_ERROR("8500", "服务器内部错误"),
    PARAM_EMPTY("8407", "请求参数不能为空"),
    PARAM_ERROR("8402", "请求参数非法"),
    LOGIN_ERROR("8900","登录失败"),
    NO_LOGIN("8910","没有登录或登录超时"),
    OTHER("8500", "服务器内部错误"),


    ;

    /**
     * 错误码
     */
    private String resultCode;

    /**
     * 错误描述
     */
    private String resultMsg;

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
