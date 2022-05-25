package com.ferrosac.mapper;

import com.ferrosac.dto.request.CategoriaRequest;
import com.ferrosac.dto.response.CategoriaResponse;
import com.ferrosac.entity.Categoria;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaMapper {

    public Categoria convertToDTO2Entity(CategoriaRequest categoriaRequest) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaRequest, categoria);
        return categoria;
    }

    public CategoriaResponse convertToEntity2DTO(Categoria categoria) {
        CategoriaResponse categoriaResponse = new CategoriaResponse();
        BeanUtils.copyProperties(categoria, categoriaResponse);
        return categoriaResponse;
    }

    public List<CategoriaResponse> convertToEntity2DTOList(List<Categoria> categoriaList) {
        List<CategoriaResponse> categoriaResponses = new ArrayList<>();
        for (Categoria categoria : categoriaList) {
            categoriaResponses.add(convertToEntity2DTO(categoria));
        }
        return categoriaResponses;
    }
}
