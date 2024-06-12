package com.project.luis_server.domain.post.client.api;

import com.project.luis_server.domain.post.application.service.PostService;
import com.project.luis_server.domain.post.client.dto.request.PostRegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Tag(name = "게시글", description = "게시글 API")
public class PostController {

    private final PostService postService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "게시글 등록", description = "게시글을 등록합니다.")
    public void registerPost(@RequestBody PostRegisterRequest request) {
        postService.registerPost(request);
    }

    @DeleteMapping("")
    @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

}
