package com.ferrosac.service;

import com.ferrosac.dto.request.CiudadRequest;
import com.ferrosac.dto.response.CiudadResponse;

import java.util.List;

public interface ICiudadService {

    CiudadResponse save(CiudadRequest ciudadRequest);

    List<CiudadResponse> getAllCiudades();

    CiudadResponse update(Long id, CiudadRequest ciudadRequest);

    void delete(Long id);
}
