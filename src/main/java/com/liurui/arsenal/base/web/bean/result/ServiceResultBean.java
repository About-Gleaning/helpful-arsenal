package com.liurui.arsenal.base.web.bean.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Description: 统一返回格式
 * 集成于ResultBean, 扩展了错误详情, 比如空指针之类的
 * 所以一般用于服务之间的结果传递, 不推荐使用于返回前端的格式
 * @Datatime: 2021/7/25 22:08
 * @Author: 渣渣瑞
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ServiceResultBean<T> extends ResultBean<T> {

    // TODO 是否集成值得考虑一下

    private String errorMsg;

    protected ServiceResultBean(int code, String msg, T data) {
        super(code, msg, data);
    }
}
