package com.ferrosac.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoResponse {

    private Long id;
    private String nombre;
    private String prefijo;
    @JsonFormat(pattern = "dd-MM-yyyy KK:mm:ss a", timezone = "America/Lima")
    private Timestamp fechaCreacion;
    @JsonFormat(pattern = "dd-MM-yyyy KK:mm:ss a", timezone = "America/Lima")
    private Timestamp fechaModificacion;
}
