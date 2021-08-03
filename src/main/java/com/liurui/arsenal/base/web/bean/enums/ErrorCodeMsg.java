package com.liurui.arsenal.base.web.bean.enums;

/**
 * @Description: 返回前端的错误码及对应文字
 * @Datatime: 2021/7/25 21:44
 * @Author: 渣渣瑞
 */
public enum ErrorCodeMsg {

    /**
     * 错误码, 文案
     */
    SUCCESS(0, "成功"),
    FAIL(10, "失败"),
    BUSINESS_ERROR(100, "业务异常"),
    NETWORK_ERROR(200, "网络异常"),
    IO_ERROR(300, "IO异常"),
    DATABASE_ERROR(400, "数据库异常"),
    APPLICATION_ERROR(500, "应用异常");

    private Integer code;
    private String msg;

    ErrorCodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
