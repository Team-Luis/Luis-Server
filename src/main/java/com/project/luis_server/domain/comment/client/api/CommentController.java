package com.project.luis_server.domain.comment.client.api;

import com.project.luis_server.domain.comment.application.service.CommentService;
import com.project.luis_server.domain.comment.client.dto.request.CommentRegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@Tag(name = "댓글", description = "댓글 API")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "댓글 등록", description = "댓글을 등록합니다.")
    public void registerComment(CommentRegisterRequest request){
        commentService.registerComment(request);
    }

}
