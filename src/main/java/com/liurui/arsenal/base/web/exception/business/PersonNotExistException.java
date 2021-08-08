package com.liurui.arsenal.base.web.exception.business;

/**
 * @Description: 用户个体不存在异常
 * @Datatime: 2021/8/8 11:13
 * @Author: 渣渣瑞
 */
public class PersonNotExistException extends BusinessException {
    public PersonNotExistException() {
        super("用户个体不存在");
    }

    public PersonNotExistException(String message) {
        super(message);
    }
}
