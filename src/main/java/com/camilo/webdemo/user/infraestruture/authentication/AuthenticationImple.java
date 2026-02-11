package com.camilo.webdemo.user.infraestruture.authentication;

import com.camilo.webdemo.common.services.JwtServie;
import com.camilo.webdemo.user.domain.ports.AuthenticationPort;
import com.camilo.webdemo.user.infraestruture.database.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationImple implements AuthenticationPort {

    private final AuthenticationManager authenticationManager;
    private final JwtServie jwtServie;

    @Override
    public String authentication(String email, String password) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                ));

        UserEntity entity = (UserEntity) authenticate.getPrincipal();
        return jwtServie.generateToken(entity);
    }
}
