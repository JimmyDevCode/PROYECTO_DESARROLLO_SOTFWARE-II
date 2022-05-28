package com.ferrosac.service.impl;

import com.ferrosac.dto.request.CiudadRequest;
import com.ferrosac.dto.response.CiudadResponse;
import com.ferrosac.entity.Ciudad;
import com.ferrosac.exception.ParamNotFound;
import com.ferrosac.mapper.CiudadMapper;
import com.ferrosac.repository.ICiudadRepository;
import com.ferrosac.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadServiceImpl implements ICiudadService {

    @Autowired
    ICiudadRepository iCiudadRepository;
    @Autowired
    CiudadMapper ciudadMapper;

    private static final String CIUDAD_NOT_FOUND_MESSAGE = "Ciudad no encontrada.";

    @Override
    public CiudadResponse save(CiudadRequest ciudadRequest) {
        Ciudad ciudad = ciudadMapper.convertToDTO2Entity(ciudadRequest);
        return ciudadMapper.convertToEntity2DTO(iCiudadRepository.save(ciudad));
    }

    @Override
    public List<CiudadResponse> getAllCiudades() {
        List<Ciudad> ciudades = iCiudadRepository.findAll();
        return ciudadMapper.convertToEntity2DTOList(ciudades);
    }

    @Override
    public CiudadResponse update(Long id, CiudadRequest ciudadRequest) {
        Ciudad ciudad = getCiudad(id);
        ciudad.setNombre(ciudadRequest.getNombre());
        ciudad.setIdDepartamento(ciudadRequest.getIdDepartamento());
        return ciudadMapper.convertToEntity2DTO(iCiudadRepository.save(ciudad));
    }

    @Override
    public void delete(Long id) {
        this.iCiudadRepository.deleteById(id);
    }

    private Ciudad getCiudad(Long id) {
        Optional<Ciudad> ciudadOptional = iCiudadRepository.findById(id);
        if (ciudadOptional.isEmpty()) {
            throw new ParamNotFound(CIUDAD_NOT_FOUND_MESSAGE);
        }
        return ciudadOptional.get();
    }
}
