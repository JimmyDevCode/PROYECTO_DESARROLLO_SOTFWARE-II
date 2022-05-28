package com.ferrosac.service;

import com.ferrosac.dto.request.DepartamentoRequest;
import com.ferrosac.dto.response.DepartamentoResponse;

import java.util.List;

public interface IDepartamentoService {

    DepartamentoResponse save(DepartamentoRequest departamentoRequest);

    List<DepartamentoResponse> getAllDepartamentos();

    DepartamentoResponse update(Long id, DepartamentoRequest departamentoRequest);

    void delete(Long id);
}
