package com.project.luis_server.domain.auth.service;

import com.project.luis_server.domain.auth.client.dto.request.SignInRequest;
import com.project.luis_server.domain.auth.client.dto.request.SignUpRequest;
import com.project.luis_server.domain.auth.client.dto.response.JsonWebTokenResponse;
import com.project.luis_server.domain.auth.client.dto.response.RefreshTokenResponse;
import com.project.luis_server.domain.user.application.util.UserUtil;
import com.project.luis_server.domain.user.client.dto.User;
import com.project.luis_server.domain.user.domain.enums.UserRole;
import com.project.luis_server.domain.user.domain.mapper.UserMapper;
import com.project.luis_server.domain.user.domain.repository.jpa.UserRepository;
import com.project.luis_server.domain.user.exception.PasswordWrongException;
import com.project.luis_server.domain.user.exception.UserExistException;
import com.project.luis_server.domain.user.exception.UserNotFoundException;
import com.project.luis_server.global.security.jwt.JwtExtract;
import com.project.luis_server.global.security.jwt.JwtProvider;
import com.project.luis_server.global.security.jwt.enums.JwtType;
import com.project.luis_server.global.security.jwt.exception.TokenTypeException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final JwtExtract jwtExtract;

    @Override
    public void signUp(SignUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserExistException.EXCEPTION;
        }
        userRepository.save(userMapper.toCreate(
                request, encoder.encode(request.getPassword()))
        );
    }

    @Override
    public JsonWebTokenResponse signIn(SignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).map(userMapper::toUser).orElseThrow(()->UserNotFoundException.EXCEPTION);
        String password = user.getPassword();
        if (!encoder.matches(request.getPassword(), password))
            throw PasswordWrongException.EXCEPTION;
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.getEmail(),user.getUserRole()))
                .refreshToken(jwtProvider.generateRefreshToken(request.getEmail(), user.getUserRole()))
                .build();
    }

    @Override
    public RefreshTokenResponse refresh(String token) {
        Jws<Claims> claims = jwtProvider.getClaims(jwtExtract.extractToken(token));
        if (jwtExtract.isWrongType(claims, JwtType.REFRESH)) {
            throw TokenTypeException.EXCEPTION;
        }
        return RefreshTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(claims.getBody().getSubject(),
                        (UserRole) claims.getHeader().get("authority"))).build();
    }

}
