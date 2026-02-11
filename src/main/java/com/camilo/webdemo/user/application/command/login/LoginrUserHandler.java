package com.camilo.webdemo.user.application.command.login;

import com.camilo.webdemo.common.application.mediator.RequestHandler;
import com.camilo.webdemo.user.domain.ports.AuthenticationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginrUserHandler implements RequestHandler<LoginUserRequest, LoginUserResponse> {
    private final AuthenticationPort authenticationPort;

    @Override
    public LoginUserResponse handle(LoginUserRequest requst) {
        String token = authenticationPort.authentication(requst.getEmail(), requst.getPassword());


        return new LoginUserResponse(token);
    }

    @Override
    public Class<LoginUserRequest> getReuestType() {
        return LoginUserRequest.class;
    }
}
