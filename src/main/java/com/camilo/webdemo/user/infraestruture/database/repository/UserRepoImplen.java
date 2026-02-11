package com.camilo.webdemo.user.infraestruture.database.repository;

import com.camilo.webdemo.user.domain.User;
import com.camilo.webdemo.user.domain.ports.UserRepository;
import com.camilo.webdemo.user.infraestruture.database.entity.QueryUserRepo;
import com.camilo.webdemo.user.infraestruture.database.entity.UserEntity;
import com.camilo.webdemo.user.infraestruture.database.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepoImplen implements UserRepository {

    private final QueryUserRepo queryUserRepo;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> findByEmail(String email) {
        return queryUserRepo.findByemail(email).map(userEntityMapper::mapToUser);
    }

    @Override
    public boolean existsByEmail(String email) {
        return queryUserRepo.findByemail(email).isPresent();
    }

    @Override
    public User upsert(User user) {
        UserEntity userEntity = userEntityMapper.mapToEntity(user);
        UserEntity save = queryUserRepo.save(userEntity);
        return userEntityMapper.mapToUser(save);
    }
}
