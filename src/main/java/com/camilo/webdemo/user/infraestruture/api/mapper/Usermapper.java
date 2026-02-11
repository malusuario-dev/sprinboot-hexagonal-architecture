package com.camilo.webdemo.user.infraestruture.api.mapper;

import com.camilo.webdemo.user.application.command.login.LoginUserRequest;
import com.camilo.webdemo.user.application.command.login.LoginUserResponse;
import com.camilo.webdemo.user.application.command.register.RegisterUserRequest;
import com.camilo.webdemo.user.application.command.register.RegisterUserResponse;
import com.camilo.webdemo.user.infraestruture.api.dto.LoginRequestDto;
import com.camilo.webdemo.user.infraestruture.api.dto.RegisterDTO;
import com.camilo.webdemo.user.infraestruture.api.dto.TokenResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface Usermapper {

    LoginUserRequest mapToLoginUserRequest(LoginRequestDto loginRequestDto);

    TokenResponseDto mapToTokenResponse(LoginUserResponse loginUserResponse);

    TokenResponseDto mapToTokenResponse(RegisterUserResponse registerUserResponse);

    RegisterUserRequest mapToRegsiterUserRequest(RegisterDTO registerDTO);

}
