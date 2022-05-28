package com.ferrosac.dto.request;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoRequest {

    @Setter(AccessLevel.NONE)
    private String nombre;

    @Setter(AccessLevel.NONE)
    private String prefijo;

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo.toUpperCase();
    }

}
