package com.risingcamp.grittest.controller.admin.report;

import com.risingcamp.grittest.controller.admin.report.dto.DeletePostReportRequestDto;
import com.risingcamp.grittest.controller.admin.report.dto.SearchPostReportRequestDto;
import com.risingcamp.grittest.controller.admin.report.dto.SearchPostReportResponseDto;
import com.risingcamp.grittest.repository.user.entity.User;
import com.risingcamp.grittest.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/report")
@RequiredArgsConstructor
@Tag(name = "Admin Report", description = "관리자의 ReportPost(신고)관련 작업들")
public class AdminReportController {
    private final AdminService adminService;

    // 관리자가 전체 postreport 볼 수 있게 처리
    @Secured("ROLE_ADMIN")
    @GetMapping("")
    public ResponseEntity<List<SearchPostReportResponseDto>> findAll(@RequestBody @Valid SearchPostReportRequestDto request) {
        List<SearchPostReportResponseDto> postReports = adminService.findPostReport(request);
        return ResponseEntity.ok(postReports);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("{postReportId}")
    public ResponseEntity<Void> deletePostReport(@PathVariable Integer postReportId,
                                                 @RequestBody DeletePostReportRequestDto request,
                                                 @AuthenticationPrincipal User user) {
        adminService.deletePostReport(postReportId, request, user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
