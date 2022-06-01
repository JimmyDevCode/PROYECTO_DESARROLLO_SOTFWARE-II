package com.ferrosac.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDetailsResponse {

    private String nombre;
    private String apellido;
    private String username;
    private String token;
}
