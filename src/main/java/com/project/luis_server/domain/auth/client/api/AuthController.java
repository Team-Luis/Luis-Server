package com.project.luis_server.domain.auth.client.api;

import com.project.luis_server.domain.auth.client.dto.request.RefreshTokenRequest;
import com.project.luis_server.domain.auth.client.dto.request.SignInRequest;
import com.project.luis_server.domain.auth.client.dto.request.SignUpRequest;
import com.project.luis_server.domain.auth.client.dto.response.JsonWebTokenResponse;
import com.project.luis_server.domain.auth.client.dto.response.RefreshTokenResponse;
import com.project.luis_server.domain.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name = "인증", description = "인증 API")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    @Operation(summary = "회원가입", description = "회원가입")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@Validated @RequestBody SignUpRequest signUpRequest){
        authService.signUp(signUpRequest);
    }

    @PostMapping("/sign-in")
    @Operation(summary = "로그인", description = "로그인")
    public JsonWebTokenResponse signIn(@Validated @RequestBody SignInRequest signInRequest){
        return authService.signIn(signInRequest);
    }

    @PostMapping("/refresh")
    @Operation(summary = "토큰 재발급", description = "access 토큰을 재발급 합니다")
    public RefreshTokenResponse refresh(RefreshTokenRequest request){
        return authService.refresh(request.getRefreshToken());
    }

}
