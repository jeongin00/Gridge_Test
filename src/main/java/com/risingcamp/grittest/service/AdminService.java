package com.risingcamp.grittest.service;

import com.risingcamp.grittest.controller.admin.AdminPost.dto.DeletePostRequestDto;
import com.risingcamp.grittest.controller.admin.AdminPost.dto.SearchPostRequestDto;
import com.risingcamp.grittest.controller.admin.AdminPost.dto.SearchPostResponseDto;
import com.risingcamp.grittest.controller.admin.AdminPost.dto.UpdatePostRequestDto;
import com.risingcamp.grittest.controller.admin.AdminReport.dto.DeletePostReportRequestDto;
import com.risingcamp.grittest.controller.admin.AdminReport.dto.SearchPostReportRequestDto;
import com.risingcamp.grittest.controller.admin.AdminReport.dto.SearchPostReportResponseDto;
import com.risingcamp.grittest.controller.admin.AdminUser.dto.DeleteUserRequestDto;
import com.risingcamp.grittest.controller.admin.AdminUser.dto.SearchUserRequestDto;
import com.risingcamp.grittest.controller.admin.AdminUser.dto.SearchUserResponseDto;
import com.risingcamp.grittest.controller.admin.AdminUser.dto.UpdateUserRequestDto;
import com.risingcamp.grittest.exception.BaseException;
import com.risingcamp.grittest.repository.admin.post.PostHistoryRepository;
import com.risingcamp.grittest.repository.admin.post.entity.PostHistory;

import com.risingcamp.grittest.repository.admin.postReport.PostReportHistoryRepository;
import com.risingcamp.grittest.repository.admin.postReport.entity.PostReportHistory;
import com.risingcamp.grittest.repository.admin.user.UserHistoryRepository;
import com.risingcamp.grittest.repository.admin.user.entity.UserHistory;
import com.risingcamp.grittest.repository.post.PostRepository;
import com.risingcamp.grittest.repository.post.entity.Post;
import com.risingcamp.grittest.repository.post.entity.PostStatus;
import com.risingcamp.grittest.repository.postReport.PostReportRepository;
import com.risingcamp.grittest.repository.postReport.entity.PostReport;
import com.risingcamp.grittest.repository.postReport.entity.PostReportStatus;
import com.risingcamp.grittest.repository.user.UserRepository;
import com.risingcamp.grittest.repository.user.entity.User;
import com.risingcamp.grittest.repository.user.entity.UserStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final UserHistoryRepository userHistoryRepository;
    private final PostRepository postRepository;
    private final PostHistoryRepository postHistoryRepository;
    private final PostReportRepository postReportRepository;
    private final PostReportHistoryRepository postReportHistoryRepository;

    // 유저 전체 조회
    public List<SearchUserResponseDto> findUsers(SearchUserRequestDto request){
        List<User> users = userRepository.findAll();  // 유저 전체 조회 pagable 사용 불가

        Stream<User> stream = users.stream();

        if(request.getNickname() != null){
            stream = stream.filter(user -> user.getNickname().contains(request.getNickname()));
        }
        if(request.getLoginId() != null){
            stream = stream.filter(user -> user.getLoginId().contains(request.getLoginId()));
        }
        if(request.getUserStatus() != null){
            stream = stream.filter(user -> user.getUserStatus().equals(request.getUserStatus()));
        }
        if(request.getCreatedAt() != null){
            stream = stream.filter(user -> user.getCreatedAt().toLocalDate().isEqual(request.getCreatedAt().toLocalDate()));  //contains는 LocalDateTime을 담을 수 없음
        }


        return stream
                .sorted(Comparator.comparing(User::getCreatedAt).reversed())
                .skip((long) request.getPageIndex() * request.getSize())
                .limit(request.getSize())
                .map(SearchUserResponseDto::from)
                .toList();
    }
    
    // 유저 상세 조회
    
    // 유저 상태 변경
    @Transactional
    public void update(Integer id, UpdateUserRequestDto request, User adminuser){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new BaseException(HttpStatus.NOT_FOUND,"데이터베이스 내에 회원이 존재하지 않습니다."));

        UserHistory userHistory = UserHistory.create(user.getNickname(),
                user.getUserStatus(),
                UserStatus.BLOCKED, // 계정정지  휴먼계정 처리할지 고민해야함
                request.getReason(),
                adminuser.getLoginId()
        );
        userHistoryRepository.save(userHistory);

        user.setUserStatus(UserStatus.BLOCKED);
    }
    
    // 유저 삭제
    @Transactional
    public void userDelete(Integer id, DeleteUserRequestDto request, User adminuser){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new BaseException(HttpStatus.NOT_FOUND,"데이터베이스 내에 회원이 존재하지 않습니다."));

        UserHistory userHistory = UserHistory.create(user.getNickname(),
                user.getUserStatus(),
                UserStatus.DELETED,
                request.getReason(),
                adminuser.getLoginId()
        );
        userHistoryRepository.save(userHistory);

        userRepository.deleteById(id);
    }

    public List<SearchPostResponseDto> findPosts(SearchPostRequestDto request){
        List<Post> posts = postRepository.findAll();  // 유저 전체 조회 pagable 사용 불가

        Stream<Post> stream = posts.stream();

        if(request.getLoginId() != null){
            stream = stream.filter(post -> post.getCreatedBy().getLoginId().contains(request.getLoginId()));
        }
        if(request.getPostStatus() != null){
            stream = stream.filter(post -> post.getPostStatus().equals(request.getPostStatus()));
        }
        if(request.getCreatedAt() != null){
            stream = stream.filter(post -> post.getCreatedAt().toLocalDate().isEqual(request.getCreatedAt().toLocalDate()));  //contains는 LocalDateTime을 담을 수 없음
        }


        return stream
                .sorted(Comparator.comparing(Post::getCreatedAt).reversed())
                .skip((long) request.getPageIndex() * request.getSize())
                .limit(request.getSize())
                .map(SearchPostResponseDto::from)
                .toList();

    }

    // 포스트 상태변경
    @Transactional
    public void postStatus(Integer postId,
                           UpdatePostRequestDto request,
                           @AuthenticationPrincipal User user){
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new BaseException(HttpStatus.NOT_FOUND,"데이터베이스내 포스트가 존재하지않습니다."));

        PostHistory postHistory = PostHistory.create(
                post.getCreatedBy().getNickname(),
                post.getPostStatus(),
                PostStatus.INVISIBLE,
                request.getReason(),
                user.getLoginId()
        );
        postHistoryRepository.save(postHistory);

        post.setPostStatus(PostStatus.INVISIBLE);
    }

    // 포스트 삭제
    @Transactional
    public void postDelete(Integer postId, DeletePostRequestDto request, @AuthenticationPrincipal User user){
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new BaseException(HttpStatus.NOT_FOUND,"데이터베이스내 포스트가 존재하지않습니다."));

        PostHistory postHistory = PostHistory.create(
                post.getCreatedBy().getNickname(),
                post.getPostStatus(),
                PostStatus.DELETED,
                request.getReason(),
                user.getLoginId()
        );
        postHistoryRepository.save(postHistory);

        postRepository.delete(post);
    }

    // 신고 조회
    public List<SearchPostReportResponseDto> findPostReport(SearchPostReportRequestDto request){
        List<PostReport> postReports = postReportRepository.findAll();

        return postReports.stream()
                .sorted(Comparator.comparing(PostReport::getCreatedAt).reversed()) // 정렬 (선택 사항)
                .skip((long) request.getPageIndex() * request.getSize())
                .limit(request.getSize())
                .map(SearchPostReportResponseDto::from)
                .toList();
    }

    // 신고 삭제
    @Transactional
    public void deletePostReport(Integer postReportId, DeletePostReportRequestDto request, User adminuser){
        PostReport postReport = postReportRepository.findById(postReportId)
                .orElseThrow(()-> new BaseException(HttpStatus.NOT_FOUND,"데이터베이스 내에 신고아이디가 존재하지 않습니다."));

        PostReportHistory postReportHistory = PostReportHistory.create(postReport.getCreatedBy().getNickname(),
                postReport.getPostReportStatus(),
                PostReportStatus.DELETED,
                request.getReason(),
                adminuser.getLoginId()
        );
        postReportHistoryRepository.save(postReportHistory);

        postReportRepository.deleteById(postReportId);
    }
}
