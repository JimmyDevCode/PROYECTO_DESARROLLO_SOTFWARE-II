package com.ferrosac.service;

import com.ferrosac.dto.request.ProveedorRequest;
import com.ferrosac.dto.response.ProveedorResponse;

import java.util.List;

public interface IProveedorService {

    ProveedorResponse save(ProveedorRequest proveedorRequest);

    List<ProveedorResponse> getAllProveedores();

    ProveedorResponse update(Long id, ProveedorRequest proveedorRequest);

    void delete(Long id);
}
