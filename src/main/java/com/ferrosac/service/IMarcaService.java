package com.ferrosac.service;

import com.ferrosac.dto.request.MarcaRequest;
import com.ferrosac.dto.response.MarcaResponse;

import java.util.List;

public interface IMarcaService {

    MarcaResponse save(MarcaRequest marcaRequest);

    List<MarcaResponse> getAllMarcas();

    MarcaResponse update(Long id, MarcaRequest marcaRequest);

    void delete (Long id);
}
