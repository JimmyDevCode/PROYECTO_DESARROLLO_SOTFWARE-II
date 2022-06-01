package com.ferrosac.auth.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioAuthenticatedResponse {

    private String token;
    private String username;

    public UsuarioAuthenticatedResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
