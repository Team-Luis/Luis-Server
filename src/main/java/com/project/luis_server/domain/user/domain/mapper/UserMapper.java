package com.project.luis_server.domain.user.domain.mapper;

import com.project.luis_server.domain.auth.client.dto.request.SignUpRequest;
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

    public UserEntity toCreate(SignUpRequest signUpRequest, String password){
        return UserEntity.builder()
                .userId(signUpRequest.getUserId())
                .email(signUpRequest.getEmail())
                .password(password)
                .build();
    }

}
