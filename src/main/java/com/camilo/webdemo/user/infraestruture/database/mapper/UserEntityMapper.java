package com.camilo.webdemo.user.infraestruture.database.mapper;

import com.camilo.webdemo.user.domain.User;
import com.camilo.webdemo.user.infraestruture.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserEntityMapper {

    @Mapping(target = "authorities", ignore = true)
    UserEntity mapToEntity(User user);

    User mapToUser(UserEntity userEntity);


}
