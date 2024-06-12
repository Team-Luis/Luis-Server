package com.project.luis_server.domain.auth.service;

import com.project.luis_server.domain.auth.client.dto.request.SignInRequest;
import com.project.luis_server.domain.auth.client.dto.request.SignUpRequest;
import com.project.luis_server.domain.auth.client.dto.response.JsonWebTokenResponse;
import com.project.luis_server.domain.auth.client.dto.response.RefreshTokenResponse;

public interface AuthService {

    void signUp(SignUpRequest request);

    JsonWebTokenResponse signIn(SignInRequest request);

    RefreshTokenResponse refresh(String token);

}
