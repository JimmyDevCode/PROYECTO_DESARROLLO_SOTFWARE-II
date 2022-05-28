package com.ferrosac.mapper;

import com.ferrosac.dto.request.DistritoRequest;
import com.ferrosac.dto.response.DistritoResponse;
import com.ferrosac.entity.Ciudad;
import com.ferrosac.entity.Distrito;
import com.ferrosac.repository.ICiudadRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DistritoMapper {

    @Autowired
    ICiudadRepository iCiudadRepository;

    public Distrito convertToDTO2Entity(DistritoRequest distritoRequest) {
        Distrito distrito = new Distrito();
        BeanUtils.copyProperties(distritoRequest, distrito);
        return distrito;
    }

    public DistritoResponse convertToEntity2DTO(Distrito distrito) {
        DistritoResponse distritoResponse = new DistritoResponse();
        Ciudad ciudad = iCiudadRepository.getById(distrito.getIdCiudad());
        distritoResponse.setCiudad(ciudad.getNombre());
        BeanUtils.copyProperties(distrito, distritoResponse);
        return distritoResponse;
    }

    public List<DistritoResponse> convertToEntity2DTOList(List<Distrito> distritoList) {
        List<DistritoResponse> ciudadResponses = new ArrayList<>();
        for (Distrito distrito: distritoList) {
            ciudadResponses.add(convertToEntity2DTO(distrito));
        }
        return ciudadResponses;
    }
}
