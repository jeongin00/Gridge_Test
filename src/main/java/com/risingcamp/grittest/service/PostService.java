package com.risingcamp.grittest.service;


import com.risingcamp.grittest.exception.BaseException;
import com.risingcamp.grittest.repository.likes.LikesRepository;
import com.risingcamp.grittest.controller.post.dto.*;
import com.risingcamp.grittest.repository.post.PostRepository;
import com.risingcamp.grittest.repository.post.entity.Post;
import com.risingcamp.grittest.repository.post.entity.PostStatus;
import com.risingcamp.grittest.repository.postImedia.PostMediaRepository;
import com.risingcamp.grittest.repository.postImedia.entity.PostMedia;
import com.risingcamp.grittest.repository.postReport.PostReportRepository;
import com.risingcamp.grittest.repository.postReport.entity.PostReport;
import com.risingcamp.grittest.repository.user.UserRepository;
import com.risingcamp.grittest.repository.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final LikesRepository likesRepository;
    private final PostMediaRepository postMediaRepository;
    private final PostReportRepository postReportRepository;

    @Transactional
    public PostCreateResponseDto save(PostCreateRequestDto request,  @AuthenticationPrincipal User user){
        Post post = Post.create(
            request.getContent(),
                user
        );

        Post created = postRepository.save(post);

        // dto 를 entity 로 변환해야함
        List<PostMedia> postMedias = request.getPostMedias()
                        .stream()
                                .map(dto->PostMedia.create(dto.getMediaUrl(), dto.getMediaType(), post))
                                        .toList();

        postMediaRepository.saveAll(postMedias);
        post.setPostMedia(postMedias);
        return PostCreateResponseDto.from(created);
    }

    @Transactional
    public List<PostResponseDto> getPosts(PostListRequestDto request){
        Pageable pageable = PageRequest.of(
                request.getPageIndex(),
                request.getSize(),
                Sort.by(Sort.Direction.DESC,"createdAt")
        );

        List<PostResponseDto> posts = postRepository.findAllByPostStatus(PostStatus.VISIBLE,pageable)
                .stream()
                .map(post -> PostResponseDto.from(post , likesRepository.countByPostId(post.getId())))
                .toList();
        return posts;
    }

    @Transactional
    public PostReportCreateResponseDto postReport(Integer postId, PostReportCreateRequestDto request, @AuthenticationPrincipal User user)
    {
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new BaseException(HttpStatus.NOT_FOUND,"데이터베이스내 포스트가 존재하지않습니다."));

        PostReport postReport = PostReport.create(
                post,
                request.getTitle(),
                request.getContent(),
                user
        );

        postReportRepository.save(postReport);

        // 일단 한 번 신고하면 바로 숨김처리
        post.setPostStatus(PostStatus.INVISIBLE);

        return PostReportCreateResponseDto.from(postReport);
    }
}
