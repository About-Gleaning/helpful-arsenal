package com.liurui.arsenal.base.web.bean.result;

import com.liurui.arsenal.base.web.bean.enums.ErrorCodeMsg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Description: 统一返回格式
 * @Datatime: 2021/7/25 21:44
 * @Author: 渣渣瑞
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class BaseResult<T> {
    private int code;
    private String msg;
    private T data;

    protected BaseResult() {
    }

    protected BaseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> BaseResult<T> getInstance(int code) {
        return getInstance(code, null);
    }

    public static <T> BaseResult<T> getInstance(int code, T data) {
        return new BaseResult<T>(code, "", data);
    }

    public static BaseResult<?> getInstance(ErrorCodeMsg error) {
        return getInstance(error, null);
    }

    public static <T> BaseResult<?> getInstance(ErrorCodeMsg error, T data) {
        return getInstance(error.getCode(), data).setMsg("");
    }

    public static BaseResult success() {
        return getInstance(ErrorCodeMsg.SUCCESS.getCode());
    }

    public static <T> BaseResult<T> succuess(T data) {
        return getInstance(ErrorCodeMsg.SUCCESS.getCode(), data);
    }

    public static BaseResult fail() {
        return getInstance(ErrorCodeMsg.FAIL.getCode());
    }

    public static <T> BaseResult<T> fail(T data) {
        return getInstance(ErrorCodeMsg.FAIL.getCode(), data);
    }

}
