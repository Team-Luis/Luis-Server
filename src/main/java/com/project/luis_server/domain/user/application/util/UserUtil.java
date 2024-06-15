package com.project.luis_server.domain.user.application.util;

import com.project.luis_server.domain.auth.client.dto.request.SignUpRequest;
import com.project.luis_server.domain.user.client.dto.User;
import com.project.luis_server.domain.user.domain.mapper.UserMapper;
import com.project.luis_server.domain.user.domain.repository.jpa.UserRepository;
import com.project.luis_server.domain.user.exception.UserExistException;
import com.project.luis_server.domain.user.exception.UserNotFoundException;
import com.project.luis_server.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {

    private final UserRepository userRepository;
    private final UserSecurity userSecurity;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public void userExistCheck(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw UserExistException.EXCEPTION;
        }
    }

    public User findUser() {
        return userRepository
                .findById(userSecurity.getUser().getIdx())
                .map(userMapper::toUser)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void saveUser(SignUpRequest request) {
        userRepository.save(userMapper.toCreate(
                request, encoder.encode(request.getPassword()))
        );
    }
}
