package com.risingcamp.grittest.service;


import com.risingcamp.grittest.controller.post.dto.*;
import com.risingcamp.grittest.repository.like.LikeRepository;
import com.risingcamp.grittest.repository.post.PostRepository;
import com.risingcamp.grittest.repository.post.entity.Post;
import com.risingcamp.grittest.repository.postImedia.PostMediaRepository;
import com.risingcamp.grittest.repository.postImedia.entity.PostMedia;
import com.risingcamp.grittest.repository.user.UserRepository;
import com.risingcamp.grittest.repository.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostMediaRepository postMediaRepository;

    @Transactional
    public PostCreateResponseDto save(PostCreateRequestDto request,  @AuthenticationPrincipal User user){
        Post post = Post.create(
            request.getContent(),
                user
        );

        // dto 를 entity 로 변환해야함
        List<PostMedia> postMedias = request.getPostMedias()
                        .stream()
                                .map(dto->PostMedia.create(dto.getMediaUrl(), dto.getMediaType(), post))
                                        .toList();

        postMediaRepository.saveAll(postMedias);

        post.setPostMedia(postMedias);

        Post created = postRepository.save(post);

        return PostCreateResponseDto.from(created);
    }

    @Transactional
    public List<PostResponseDto> getPosts(PostListRequestDto request){
        Pageable pageable = PageRequest.of(
                request.getPageIndex(),
                request.getSize(),
                Sort.by(Sort.Direction.DESC,"createdAt")
        );

        List<PostResponseDto> posts = postRepository.findAll(pageable)
                .stream()
                .map(post -> PostResponseDto.from(post , likeRepository.countByPostId(post.getId())))
                .toList();


        return posts;
    }
}