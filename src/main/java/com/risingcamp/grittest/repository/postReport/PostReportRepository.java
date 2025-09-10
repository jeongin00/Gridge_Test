package com.risingcamp.grittest.repository.postReport;

import com.risingcamp.grittest.repository.postReport.entity.PostReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReportRepository extends JpaRepository<PostReport, Integer> {
}
