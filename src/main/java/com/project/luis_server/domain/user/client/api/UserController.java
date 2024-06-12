package com.project.luis_server.domain.user.client.api;

import com.project.luis_server.domain.user.application.service.UserService;
import com.project.luis_server.domain.user.client.dto.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "유저", description = "유저 API")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    @Operation(summary = "유저 조회", description = "현재 로그인한 유저 정보를 조회합니다")
    public User findUser(){
        return userService.findUser();
    }

    @DeleteMapping("")
    @Operation(summary = "회원탈퇴", description = "회원 탈퇴를 진행합니다")
    public void deleteUser(){
        userService.deleteUser();
    }

}
