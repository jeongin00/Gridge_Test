/*
package com.risingcamp.grittest.controller.post;

import com.risingcamp.grittest.controller.post.dto.CommentCreateRequestDto;
import com.risingcamp.grittest.controller.post.dto.CommentResponseDto;
import com.risingcamp.grittest.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("")
    public ResponseEntity<CommentResponseDto> created(@RequestBody CommentCreateRequestDto request){
        CommentResponseDto comment = commentService.save(request);
        return ResponseEntity.ok(comment);
    }
}
*/