package com.liurui.arsenal.base.web.bean.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Description: 当前登录用户上下文
 * @Datatime: 2021/7/25 21:44
 * @Author: 渣渣瑞
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class UserContext {

    private String userId;
    private String userName;
    private String token;

    private UserContext() {
    }

    public static UserContext getInstance() {
        return new UserContext();
    }

}
