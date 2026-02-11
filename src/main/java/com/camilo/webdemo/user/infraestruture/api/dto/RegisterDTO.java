package com.camilo.webdemo.user.infraestruture.api.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class RegisterDTO {
    @Email
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
