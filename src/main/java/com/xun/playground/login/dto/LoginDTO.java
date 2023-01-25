package com.xun.playground.login.dto;

import com.xun.playground.login.form.LoginForm;
import lombok.Getter;
import lombok.Setter;

/**
 * Login DTO
 */
@Getter
@Setter
public class LoginDTO {
    private String loginId;
    private String password;

    public LoginDTO(){}

    public LoginDTO(LoginForm loginForm){
        this.loginId = loginForm.getLoginId();
        this.password = loginForm.getPassword();
    }
}
