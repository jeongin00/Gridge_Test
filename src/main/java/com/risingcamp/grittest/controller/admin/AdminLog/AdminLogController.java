package com.risingcamp.grittest.controller.admin.AdminLog;


import com.risingcamp.grittest.controller.admin.AdminLog.dto.*;
import com.risingcamp.grittest.service.LogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/adminLog")
public class AdminLogController {
    private final LogService logService;
    // UserHistory 전체조회
    @Secured("ROLE_ADMIN")
    @GetMapping("/users")
    public ResponseEntity<List<UserHistoryResponseDto>> findAll(@RequestBody @Valid UserHistoryRequestDto request)
    {
        List<UserHistoryResponseDto> logs = logService.findUsers(request);
        return ResponseEntity.ok(logs);
    }


    // PostHistory 전체조회
    @Secured("ROLE_ADMIN")
    @GetMapping("/posts")
    public ResponseEntity<List<PostHistoryResponseDto>> findAll(@RequestBody @Valid PostHistoryRequestDto request){
        List<PostHistoryResponseDto> logs = logService.findPosts(request);
        return ResponseEntity.ok(logs);
    }

    // PostHistory 전체조회
    @Secured("ROLE_ADMIN")
    @GetMapping("/reports")
    public ResponseEntity<List<ReportHistoryResponseDto>> findAll(@RequestBody @Valid ReportHistoryRequestDto request){
        List<ReportHistoryResponseDto> logs = logService.findReports(request);
        return ResponseEntity.ok(logs);
    }
}
