package com.risingcamp.grittest.service;

import com.risingcamp.grittest.controller.admin.log.dto.*;
import com.risingcamp.grittest.repository.admin.post.PostHistoryRepository;
import com.risingcamp.grittest.repository.admin.post.entity.PostHistory;
import com.risingcamp.grittest.repository.admin.postReport.PostReportHistoryRepository;
import com.risingcamp.grittest.repository.admin.postReport.entity.PostReportHistory;
import com.risingcamp.grittest.repository.admin.user.UserHistoryRepository;
import com.risingcamp.grittest.repository.admin.user.entity.UserHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final UserHistoryRepository userHistoryRepository;
    private final PostHistoryRepository postHistoryRepository;
    private final PostReportHistoryRepository postReportHistoryRepository;

    public List<UserHistoryResponseDto> findUsers(UserHistoryRequestDto request) {
        List<UserHistory> userHistory = userHistoryRepository.findAll();

        return userHistory.stream()
                .map(UserHistoryResponseDto::from)
                .toList();
    }

    public List<PostHistoryResponseDto> findPosts(PostHistoryRequestDto request) {
        List<PostHistory> postHistory = postHistoryRepository.findAll();

        return postHistory.stream()
                .map(PostHistoryResponseDto::from)
                .toList();
    }

    public List<ReportHistoryResponseDto> findReports(ReportHistoryRequestDto request) {
        List<PostReportHistory> postReportHistory = postReportHistoryRepository.findAll();

        return postReportHistory.stream()
                .map(ReportHistoryResponseDto::from)
                .toList();
    }
}
