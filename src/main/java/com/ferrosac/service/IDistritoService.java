package com.ferrosac.service;


import com.ferrosac.dto.request.DistritoRequest;
import com.ferrosac.dto.response.DistritoResponse;

import java.util.List;

public interface IDistritoService {

    DistritoResponse save(DistritoRequest distritoRequest);

    List<DistritoResponse> getAllCiudades();

    DistritoResponse update(Long id, DistritoRequest distritoRequest);

    void delete(Long id);
}
