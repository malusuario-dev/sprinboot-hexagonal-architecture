package com.camilo.webdemo.user.application.command.register;

import com.camilo.webdemo.common.application.mediator.RequestHandler;
import com.camilo.webdemo.user.domain.User;
import com.camilo.webdemo.user.domain.UserRole;
import com.camilo.webdemo.user.domain.ports.AuthenticationPort;
import com.camilo.webdemo.user.domain.ports.PasswordEncodePort;
import com.camilo.webdemo.user.domain.ports.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserHandler implements RequestHandler<RegisterUserRequest, RegisterUserResponse> {
    private final UserRepository userRepository;
    private final PasswordEncodePort passwordEncodePort;
    private final AuthenticationPort authenticationPort;

    @Override
    public RegisterUserResponse handle(RegisterUserRequest requst) {
        boolean existByEmail = userRepository.existsByEmail(requst.getEmail());

        if (existByEmail) {
            throw new RuntimeException("email ya existe");
        }

        String encoded = passwordEncodePort.encode(requst.getPassword());
        User user = User.builder()
                .email(requst.getEmail())
                .password(encoded)
                .role(UserRole.USER)
                .firstName(requst.getFirstName())
                .lastName(requst.getLastName())
                .build();

        userRepository.upsert(user);
        String token = authenticationPort.authentication(requst.getEmail(), requst.getPassword());
        return new RegisterUserResponse(token);
    }

    @Override
    public Class<RegisterUserRequest> getReuestType() {
        return RegisterUserRequest.class;
    }
}
