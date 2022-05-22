package com.ferrosac.service.impl;

import com.ferrosac.dto.request.MarcaRequest;
import com.ferrosac.dto.response.MarcaResponse;
import com.ferrosac.entity.Marca;
import com.ferrosac.exception.ParamNotFound;
import com.ferrosac.mapper.DtoMapper;
import com.ferrosac.mapper.EntityMapper;
import com.ferrosac.repository.IMarcaRepository;
import com.ferrosac.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements IMarcaService {

    private static final String MARCA_NOT_FOUND_MESSAGE = "Marca no encontrada.";

    @Autowired
    private IMarcaRepository iMarcaRepository;

    @Override
    public MarcaResponse save(MarcaRequest marcaRequest) {
        Marca marca = DtoMapper.converToDTO2Entity(marcaRequest);
        return EntityMapper.converToEntity2DTO(iMarcaRepository.save(marca));
    }

    @Override
    public List<MarcaResponse> getAllMarcas() {
        List<Marca> marcas = iMarcaRepository.findAll();
        return EntityMapper.converToEntity2DTOList(marcas);
    }

    @Override
    public MarcaResponse update(Long id, MarcaRequest marcaRequest) {
        Marca marca = getMarca(id);
        return EntityMapper.converToEntity2DTO(iMarcaRepository.save(marca));
    }

    @Override
    public void delete(Long id) {
        this.iMarcaRepository.deleteById(id);
    }

    private Marca getMarca(Long id){
        Optional<Marca> marcaOptional = iMarcaRepository.findById(id);
        if(marcaOptional.isEmpty()){
            throw new ParamNotFound(MARCA_NOT_FOUND_MESSAGE);
        }
        return marcaOptional.get();
    }
}
