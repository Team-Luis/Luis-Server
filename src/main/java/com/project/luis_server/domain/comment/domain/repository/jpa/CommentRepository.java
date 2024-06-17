package com.project.luis_server.domain.comment.domain.repository.jpa;

import com.project.luis_server.domain.comment.domain.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
