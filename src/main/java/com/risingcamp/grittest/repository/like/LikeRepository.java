package com.risingcamp.grittest.repository.like;

import com.risingcamp.grittest.repository.like.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {
    Long countByPostId(Integer postId);
}
