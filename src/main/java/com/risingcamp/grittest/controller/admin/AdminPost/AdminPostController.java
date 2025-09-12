package com.risingcamp.grittest.controller.admin.AdminPost;

import com.risingcamp.grittest.controller.admin.AdminPost.dto.DeletePostRequestDto;
import com.risingcamp.grittest.controller.admin.AdminPost.dto.SearchPostRequestDto;
import com.risingcamp.grittest.controller.admin.AdminPost.dto.SearchPostResponseDto;
import com.risingcamp.grittest.controller.admin.AdminPost.dto.UpdatePostRequestDto;
import com.risingcamp.grittest.controller.post.dto.PostCreateRequestDto;
import com.risingcamp.grittest.controller.post.dto.PostCreateResponseDto;
import com.risingcamp.grittest.repository.user.entity.User;
import com.risingcamp.grittest.service.AdminService;
import com.risingcamp.grittest.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/adminPost")
public class AdminPostController {
    private final PostService postService;
    private final AdminService adminService;

    // 관리자용 post 생성
    @Secured("ROLE_ADMIN")
    @PostMapping("")
    @Operation(summary = "관리자 게시글작성", description = "홈페이지 공지사항 작성")
    public ResponseEntity<PostCreateResponseDto> create(@RequestBody PostCreateRequestDto request, @AuthenticationPrincipal User user){
        PostCreateResponseDto post = postService.save(request, user);
        return ResponseEntity.ok(post);
    }


    // 관리자용 post 조회
    @Secured("ROLE_ADMIN")
    @GetMapping("/posts")
    @Operation(summary = "유저게시글 전체 조회", description = "유저가 작성한 게시글 페이징으로 조회")
    public ResponseEntity<List<SearchPostResponseDto>> findByAll(@RequestBody @Valid SearchPostRequestDto request){
        List<SearchPostResponseDto> users = adminService.findPosts(request);
        return ResponseEntity.ok(users);
    }

    // 관리자가 post invisible 할 수 있게 처리하기
    @Secured("ROLE_ADMIN")
    @PutMapping("/{postId}/status")
    @Operation(summary = "게시글 상태 변경")
    public ResponseEntity<String> postStatus(@PathVariable Integer postId,
                                             @RequestBody UpdatePostRequestDto request,
                                             @AuthenticationPrincipal User user){
        adminService.postStatus(postId, request, user);
        return ResponseEntity.ok("상태가 변경되었습니다.");
    }



    // 관리자가 post 삭제 할 수 있게 관리하기
    @Secured("ROLE_ADMIN")
    @DeleteMapping("{postId}")
    @Operation(summary = "게시글 삭제", description = "사유확인 후 삭제 조치")
    public ResponseEntity<Void> delete(@PathVariable Integer postId, @RequestBody DeletePostRequestDto request, @AuthenticationPrincipal User user){
        adminService.postDelete(postId,request,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
