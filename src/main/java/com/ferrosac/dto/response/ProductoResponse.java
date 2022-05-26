package com.ferrosac.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codigo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nombre;
    private int stock;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descripcion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String categoria;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String marca;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd-MM-yyyy KK:mm:ss a", timezone = "America/Lima")
    private Timestamp fechaCreacion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd-MM-yyyy KK:mm:ss a", timezone = "America/Lima")
    private Timestamp fechaModificacion;
}
