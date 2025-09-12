package com.risingcamp.grittest.repository.admin.user;

import com.risingcamp.grittest.repository.admin.user.entity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory,Integer> {
}
