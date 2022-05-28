package com.ferrosac.mapper;

import com.ferrosac.dto.request.DepartamentoRequest;
import com.ferrosac.dto.response.DepartamentoResponse;
import com.ferrosac.entity.Departamento;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartamentoMapper {

    public Departamento convertToDTO2Entity(DepartamentoRequest departamentoRequest) {
        Departamento departamento = new Departamento();
        BeanUtils.copyProperties(departamentoRequest, departamento);
        return departamento;
    }

    public DepartamentoResponse convertToEntity2DTO(Departamento departamento) {
        DepartamentoResponse departamentoResponse = new DepartamentoResponse();
        BeanUtils.copyProperties(departamento, departamentoResponse);
        return departamentoResponse;
    }

    public List<DepartamentoResponse> convertToEntity2DTOList(List<Departamento> departamentoList) {
        List<DepartamentoResponse> departamentoResponses = new ArrayList<>();
        for (Departamento departamento : departamentoList) {
            departamentoResponses.add(convertToEntity2DTO(departamento));
        }
        return departamentoResponses;
    }
}
