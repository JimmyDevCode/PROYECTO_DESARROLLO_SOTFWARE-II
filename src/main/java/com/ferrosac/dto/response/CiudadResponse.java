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
public class CiudadResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nombre;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String departamento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd-MM-yyyy KK:mm:ss a", timezone = "America/Lima")
    private Timestamp fechaCreacion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd-MM-yyyy KK:mm:ss a", timezone = "America/Lima")
    private Timestamp fechaModificacion;
}
