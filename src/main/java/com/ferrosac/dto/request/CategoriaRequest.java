package com.ferrosac.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest {

    @Setter(AccessLevel.NONE)
    private String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }
}
