package com.ferrosac.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorRequest {

    private String razon_social;
    private String ruc;
    private String direccion;
    private Long idDistrito;
}
