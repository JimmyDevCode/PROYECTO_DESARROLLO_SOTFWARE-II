package com.ferrosac.service.impl;

import com.ferrosac.dto.request.DistritoRequest;
import com.ferrosac.dto.response.DistritoResponse;
import com.ferrosac.entity.Distrito;
import com.ferrosac.exception.ParamNotFound;
import com.ferrosac.mapper.DistritoMapper;
import com.ferrosac.repository.IDistritoRepository;
import com.ferrosac.service.IDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoServiceImpl implements IDistritoService {

    @Autowired
    IDistritoRepository iDistritoRepository;
    @Autowired
    DistritoMapper distritoMapper;

    private static final String CIUDAD_NOT_FOUND_MESSAGE = "Ciudad no encontrada.";


    @Override
    public DistritoResponse save(DistritoRequest distritoRequest) {
        Distrito distrito = distritoMapper.convertToDTO2Entity(distritoRequest);
        return distritoMapper.convertToEntity2DTO(iDistritoRepository.save(distrito));
    }

    @Override
    public List<DistritoResponse> getAllCiudades() {
        List<Distrito> distritos = iDistritoRepository.findAll();
        return distritoMapper.convertToEntity2DTOList(distritos);
    }

    @Override
    public DistritoResponse update(Long id, DistritoRequest distritoRequest) {
        Distrito distrito = getDistrito(id);
        distrito.setNombre(distritoRequest.getNombre());
        distrito.setIdCiudad(distritoRequest.getIdCiudad());
        return distritoMapper.convertToEntity2DTO(iDistritoRepository.save(distrito));
    }

    @Override
    public void delete(Long id) {
        this.iDistritoRepository.deleteById(id);
    }

    private Distrito getDistrito(Long id) {
        Optional<Distrito> distritoOptional = iDistritoRepository.findById(id);
        if (distritoOptional.isEmpty()) {
            throw new ParamNotFound(CIUDAD_NOT_FOUND_MESSAGE);
        }
        return distritoOptional.get();
    }
}
