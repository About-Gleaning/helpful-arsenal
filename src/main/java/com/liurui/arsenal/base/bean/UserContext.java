package com.liurui.arsenal.base.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

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
