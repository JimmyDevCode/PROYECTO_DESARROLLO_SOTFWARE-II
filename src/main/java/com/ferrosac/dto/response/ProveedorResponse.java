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
public class ProveedorResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String razon_social;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ruc;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String direccion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String distrito;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd-MM-yyyy KK:mm:ss a", timezone = "America/Lima")
    private Timestamp fechaCreacion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd-MM-yyyy KK:mm:ss a", timezone = "America/Lima")
    private Timestamp fechaModificacion;
}
