package com.liurui.arsenal.base.web.exception.business;

/**
 * @ClassName BusinessException
 * @Description 业务异常
 * @Author liurui
 * @Date 2021/8/3 1:59 下午
 **/
public class BusinessException extends RuntimeException {

    static final long serialVersionUID = -6469399306118587165L;

    public BusinessException() {
        super("业务异常");
    }

    public BusinessException(String message) {
        super(message);
    }
}
