package com.camilo.webdemo.user.domain.ports;


import com.camilo.webdemo.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    User upsert(User user);
}
