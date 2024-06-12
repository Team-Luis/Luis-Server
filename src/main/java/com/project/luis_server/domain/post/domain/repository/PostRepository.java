package com.project.luis_server.domain.post.domain.repository;

import com.project.luis_server.domain.post.domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
