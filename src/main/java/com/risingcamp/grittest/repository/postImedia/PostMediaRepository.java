package com.risingcamp.grittest.repository.postImedia;

import com.risingcamp.grittest.repository.postImedia.entity.PostMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMediaRepository extends JpaRepository<PostMedia,Integer> {
}
