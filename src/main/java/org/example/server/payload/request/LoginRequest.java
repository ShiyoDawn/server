package org.example.server.payload.request;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * LoginRequest 登录请求数据类
 * String username 用户名
 * String password 密码
 */
public class LoginRequest implements Serializable {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}