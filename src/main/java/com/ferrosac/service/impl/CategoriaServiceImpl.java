package com.ferrosac.service.impl;

import com.ferrosac.dto.request.CategoriaRequest;
import com.ferrosac.dto.response.CategoriaResponse;
import com.ferrosac.entity.Categoria;
import com.ferrosac.entity.Marca;
import com.ferrosac.exception.ParamNotFound;
import com.ferrosac.mapper.CategoriaMapper;
import com.ferrosac.repository.ICategoriaRepository;
import com.ferrosac.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private static final String CATEGORIA_NOT_FOUND_MESSAGE = "Categoría no encontrada.";

    @Autowired
    ICategoriaRepository iCategoriaRepository;
    @Autowired
    CategoriaMapper categoriaMapper;


    @Override
    public CategoriaResponse save(CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaMapper.convertToDTO2Entity(categoriaRequest);
        return categoriaMapper.convertToEntity2DTO(iCategoriaRepository.save(categoria));
    }

    @Override
    public List<CategoriaResponse> getAllCategorias() {
        List<Categoria> categorias = iCategoriaRepository.findAll();
        return categoriaMapper.convertToEntity2DTOList(categorias);
    }

    @Override
    public CategoriaResponse update(Long id, CategoriaRequest categoriaRequest) {
        Categoria categoria = getCategoria(id);
        categoria.setNombre(categoriaRequest.getNombre());
        return categoriaMapper.convertToEntity2DTO(iCategoriaRepository.save(categoria));
    }

    @Override
    public void delete(Long id) {
        this.iCategoriaRepository.deleteById(id);
    }

    private Categoria getCategoria(Long id) {
        Optional<Categoria> categoriaOptional = iCategoriaRepository.findById(id);
        if (categoriaOptional.isEmpty()) {
            throw new ParamNotFound(CATEGORIA_NOT_FOUND_MESSAGE);
        }
        return categoriaOptional.get();
    }
}
