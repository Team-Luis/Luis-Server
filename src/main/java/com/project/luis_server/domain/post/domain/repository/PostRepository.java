package com.project.luis_server.domain.post.domain.repository;

import com.project.luis_server.domain.post.domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    void deleteByIdx(Long idx);

    Optional<PostEntity> findByIdx(Long idx);

}
