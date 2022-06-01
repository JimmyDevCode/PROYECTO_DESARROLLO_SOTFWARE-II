package com.ferrosac.auth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAuthenticationRequest {

    @NotBlank(message = "El nombre de usuario no puede estar vacío.")
    @Size(min = 5, message = "El nombre de usuario debe tener al menos 8 caracteres.")
    private String username;

    @NotBlank(message = "La contraseña no puede estar vacia.")
    @Size(min = 8, max = 250, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;
}
