package com.ferrosac.mapper;

import com.ferrosac.dto.request.CiudadRequest;
import com.ferrosac.dto.response.CiudadResponse;
import com.ferrosac.entity.Ciudad;
import com.ferrosac.entity.Departamento;
import com.ferrosac.repository.IDepartamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CiudadMapper {

    @Autowired
    IDepartamentoRepository iDepartamentoRepository;

    public Ciudad convertToDTO2Entity(CiudadRequest ciudadRequest) {
        Ciudad ciudad = new Ciudad();
        BeanUtils.copyProperties(ciudadRequest, ciudad);
        return ciudad;
    }

    public CiudadResponse convertToEntity2DTO(Ciudad ciudad) {
        CiudadResponse ciudadResponse = new CiudadResponse();
        Departamento departamento = iDepartamentoRepository.getById(ciudad.getIdDepartamento());
        ciudadResponse.setDepartamento(departamento.getNombre());
        BeanUtils.copyProperties(ciudad, ciudadResponse);
        return ciudadResponse;
    }

    public List<CiudadResponse> convertToEntity2DTOList(List<Ciudad> ciudadList) {
        List<CiudadResponse> ciudadResponses = new ArrayList<>();
        for (Ciudad ciudad: ciudadList) {
            ciudadResponses.add(convertToEntity2DTO(ciudad));
        }
        return ciudadResponses;
    }
}
