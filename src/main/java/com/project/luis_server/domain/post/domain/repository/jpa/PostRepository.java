package com.project.luis_server.domain.post.domain.repository.jpa;

import com.project.luis_server.domain.post.domain.PostEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @Transactional(rollbackOn = Exception.class)
    void deleteByIdx(Long idx);

    Optional<PostEntity> findByIdx(Long idx);

}
