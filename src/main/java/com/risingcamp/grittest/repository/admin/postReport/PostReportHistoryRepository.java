package com.risingcamp.grittest.repository.admin.postReport;

import com.risingcamp.grittest.repository.admin.postReport.entity.PostReportHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReportHistoryRepository extends JpaRepository<PostReportHistory, Integer> {
}

