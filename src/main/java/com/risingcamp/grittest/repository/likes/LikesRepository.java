package com.risingcamp.grittest.repository.likes;

import com.risingcamp.grittest.repository.likes.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {
}
