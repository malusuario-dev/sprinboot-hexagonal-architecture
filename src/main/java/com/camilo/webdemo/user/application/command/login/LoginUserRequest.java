package com.camilo.webdemo.user.application.command.login;

import com.camilo.webdemo.common.application.mediator.Request;
import lombok.Data;

@Data
public class LoginUserRequest implements Request<LoginUserResponse> {
    private String email;
    private String password;

}
