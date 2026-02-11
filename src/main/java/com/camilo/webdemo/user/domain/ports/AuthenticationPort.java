package com.camilo.webdemo.user.domain.ports;

public interface AuthenticationPort {
    String authentication(String email, String password);
}
