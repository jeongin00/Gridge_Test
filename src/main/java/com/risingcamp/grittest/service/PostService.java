/*
package com.risingcamp.grittest.service;


import com.risingcamp.grittest.controller.post.dto.PostListRequestDto;
import com.risingcamp.grittest.controller.post.dto.PostResponseDto;
import com.risingcamp.grittest.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostResponseDto> getPosts(PostListRequestDto request){
        Pageable pageable = PageRequest.of(
                request.getPageIndex(),
                request.getSize(),
                Sort.by(Sort.Direction.DESC,"createdAt")
        );
        List<PostResponseDto> posts = postRepository.findAll(pageable)
                .stream()
                .map()
                .toList()

        return
    }
}
*/