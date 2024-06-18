package com.project.luis_server.domain.post.client.dto;

import com.project.luis_server.global.common.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post{

    private Long idx;
    private String title;
    private String content;
    private String author;
    private int likes;
    protected LocalDateTime createdDateTime;
    protected LocalDateTime modifiedDateTime;

}
