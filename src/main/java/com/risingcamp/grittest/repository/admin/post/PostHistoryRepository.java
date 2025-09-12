package com.risingcamp.grittest.repository.admin.post;

import com.risingcamp.grittest.repository.admin.post.entity.PostHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostHistoryRepository extends JpaRepository<PostHistory, Integer> {
}
