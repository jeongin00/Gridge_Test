package com.risingcamp.grittest.controller.post;

import com.risingcamp.grittest.controller.post.dto.PostCreateRequestDto;
import com.risingcamp.grittest.controller.post.dto.PostListRequestDto;
import com.risingcamp.grittest.controller.post.dto.PostResponseDto;
import com.risingcamp.grittest.repository.user.entity.User;
import com.risingcamp.grittest.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "Posts", description = "게시글에 관련된 작업")
public class PostController {
    PostService postService;


    @PostMapping("")
    @Operation(summary = "게시글 생성" , description = "로그인 후 게시글 생성")
    public ResponseEntity<PostResponseDto> create(@RequestBody PostCreateRequestDto reqeust,  @AuthenticationPrincipal User user){
        PostResponseDto post = postService.save(reqeust);
        return ResponseEntity.ok(post);
    }
    @GetMapping("")
    @Operation(summary = "게시글 목록 조회", description = "pageIndex, size 사용")
    public ResponseEntity<List<PostResponseDto>> Posts(@Valid PostListRequestDto request){
        List<PostResponseDto> posts = postService.getPosts(request);
        return ResponseEntity.ok(posts);
    }
}

