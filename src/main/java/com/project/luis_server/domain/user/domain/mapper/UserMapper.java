package com.project.luis_server.domain.user.domain.mapper;

import com.project.luis_server.domain.user.client.dto.User;
import com.project.luis_server.domain.user.domain.UserEntity;
import com.project.luis_server.domain.user.domain.enums.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserEntity entity){
        return User.builder()
                .idx(entity.getIdx())
                .userId(entity.getUserId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .userRole(UserRole.USER)
                .build();
    }

}
