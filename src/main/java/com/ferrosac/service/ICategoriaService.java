package com.ferrosac.service;


import com.ferrosac.dto.request.CategoriaRequest;
import com.ferrosac.dto.request.MarcaRequest;
import com.ferrosac.dto.response.CategoriaResponse;
import com.ferrosac.dto.response.MarcaResponse;
import com.ferrosac.entity.Categoria;

import java.util.List;

public interface ICategoriaService {

    CategoriaResponse save(CategoriaRequest categoriaRequest);

    List<CategoriaResponse> getAllCategorias();

    CategoriaResponse update(Long id, CategoriaRequest categoriaRequest);

    void delete(Long id);
}
