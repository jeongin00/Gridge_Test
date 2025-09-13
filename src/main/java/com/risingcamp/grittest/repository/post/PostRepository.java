package com.risingcamp.grittest.repository.post;

import com.risingcamp.grittest.repository.post.entity.Post;
import com.risingcamp.grittest.repository.post.entity.PostStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    @EntityGraph(attributePaths = {"likes"})
    Page<Post> findAllByPostStatus(PostStatus status, Pageable pageable);
}
