package com.project.luis_server.domain.user.client.dto;

import com.project.luis_server.domain.user.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long idx;
    private String userId;
    private String email;
    private String password;
    private UserRole userRole;

}
