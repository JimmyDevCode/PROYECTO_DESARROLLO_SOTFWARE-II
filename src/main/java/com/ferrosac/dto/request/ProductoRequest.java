package com.ferrosac.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequest {

    private String codigo;
    private String nombre;
    private Integer stock;
    private String descripcion;
    private Long idCategoria;
    private Long idMarca;

}
