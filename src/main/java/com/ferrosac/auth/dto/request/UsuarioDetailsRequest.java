package com.ferrosac.auth.dto.request;

import com.ferrosac.auth.entity.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDetailsRequest {

    @NotBlank(message = "El nombre no puede estar vacio.")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio.")
    private String apellido;

    @NotBlank(message = "El nombre de usuario no puede estar vacio.")
    @Size(min = 5, message = "El nombre de usuario debe tener al menos 8 caracteres.")
    private String username;

    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    private String password;

    private String rol;
}
