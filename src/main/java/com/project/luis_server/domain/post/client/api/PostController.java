package com.project.luis_server.domain.post.client.api;

import com.project.luis_server.domain.post.application.query.PostQueryService;
import com.project.luis_server.domain.post.application.service.PostService;
import com.project.luis_server.domain.post.client.dto.Post;
import com.project.luis_server.domain.post.client.dto.request.AddLikesRequest;
import com.project.luis_server.domain.post.client.dto.request.PostEditRequest;
import com.project.luis_server.domain.post.client.dto.request.PostRegisterRequest;
import com.project.luis_server.domain.post.client.dto.request.PostSearchRequest;
import com.project.luis_server.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Tag(name = "게시글", description = "게시글 API")
public class PostController {

    private final PostService postService;
    private final PostQueryService postQueryService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "게시글 등록", description = "게시글을 등록합니다.")
    public void registerPost(@RequestBody PostRegisterRequest request) {
        postService.registerPost(request);
    }

    @GetMapping("")
    @Operation(summary = "게시글 조회", description = "idx를 기준으로 특정 게시글을 조회합니다.")
    public Post getPost(@RequestParam Long postId) {
        return postService.getPost(postId);
    }

    @GetMapping("/list")
    @Operation(summary = "게시글 목록", description = "게시글 목록을 표시합니다.")
    public ResponseEntity<List<Post>> postList(@ModelAttribute PageRequest pageRequest) {
        return ResponseEntity.ok().body(postQueryService.postList(pageRequest));
    }

    @GetMapping("/search")
    @Operation(summary = "게시글 검색", description = "제목을 기준으로 게시글을 검색합니다.")
    public ResponseEntity<List<Post>> postSearch(@ModelAttribute PostSearchRequest request) {
        return ResponseEntity.ok().body(postQueryService.postSearch(request));
    }

    @PatchMapping("")
    @Operation(summary = "게시글 수정", description = "게시글의 제목과 내용을 수정합니다.")
    public void editPost(@RequestBody PostEditRequest request) {
        postService.editPost(request);
    }

    @PatchMapping("/likes")
    @Operation(summary = "좋아요", description = "게시글에 좋아요를 추가합니다.")
    public void addLikes(@RequestBody AddLikesRequest request){
        postService.addLikes(request);
    }

    @DeleteMapping("")
    @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    public void deletePost(@RequestParam Long postId) {
        postService.deletePost(postId);
    }

}
