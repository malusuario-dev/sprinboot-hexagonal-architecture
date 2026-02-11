package com.camilo.webdemo.user.infraestruture.api;

import com.camilo.webdemo.common.application.mediator.Mediator;
import com.camilo.webdemo.user.application.command.login.LoginUserRequest;
import com.camilo.webdemo.user.application.command.login.LoginUserResponse;
import com.camilo.webdemo.user.application.command.register.RegisterUserRequest;
import com.camilo.webdemo.user.application.command.register.RegisterUserResponse;
import com.camilo.webdemo.user.infraestruture.api.dto.LoginRequestDto;
import com.camilo.webdemo.user.infraestruture.api.dto.RegisterDTO;
import com.camilo.webdemo.user.infraestruture.api.dto.TokenResponseDto;
import com.camilo.webdemo.user.infraestruture.api.mapper.Usermapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class userController {
    private final Mediator mediator;
    private final Usermapper usermapper;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {


        LoginUserRequest request = usermapper.mapToLoginUserRequest(loginRequestDto);

        LoginUserResponse response = mediator.dispatch(request);

        TokenResponseDto tokenResponseDto = usermapper.mapToTokenResponse(response);
        return ResponseEntity.ok(tokenResponseDto);

    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDto> regsiter(@RequestBody RegisterDTO registerDTO) {


        RegisterUserRequest request = usermapper.mapToRegsiterUserRequest(registerDTO);

        RegisterUserResponse response = mediator.dispatch(request);

        TokenResponseDto tokenResponseDto = usermapper.mapToTokenResponse(response);
        return ResponseEntity.ok(tokenResponseDto);
    }
}
