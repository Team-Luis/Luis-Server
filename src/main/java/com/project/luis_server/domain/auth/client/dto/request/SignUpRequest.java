package com.project.luis_server.domain.auth.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

    private String userId;
    private String email;
    private String password;

}
