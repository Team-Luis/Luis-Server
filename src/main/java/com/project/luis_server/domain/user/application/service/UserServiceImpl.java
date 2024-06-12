package com.project.luis_server.domain.user.application.service;

import com.project.luis_server.domain.user.application.util.UserUtil;
import com.project.luis_server.domain.user.client.dto.User;
import com.project.luis_server.domain.user.domain.repository.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserUtil userUtil;

    @Override
    public User findUser(){
        return userUtil.findUser();
    }

}
