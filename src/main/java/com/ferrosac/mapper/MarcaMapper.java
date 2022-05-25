package com.ferrosac.mapper;

import com.ferrosac.dto.request.MarcaRequest;
import com.ferrosac.dto.response.MarcaResponse;
import com.ferrosac.entity.Marca;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarcaMapper {

    public Marca convertToDTO2Entity(MarcaRequest marcaRequest) {

        Marca marca = new Marca();
        BeanUtils.copyProperties(marcaRequest, marca);
        return marca;
    }

    public MarcaResponse convertToEntity2DTO(Marca marca) {
        MarcaResponse marcaResponse = new MarcaResponse();
        BeanUtils.copyProperties(marca, marcaResponse);
        return marcaResponse;
    }

    public List<MarcaResponse> convertToEntity2DTOList(List<Marca> marcaList) {
        List<MarcaResponse> marcaResponses = new ArrayList<>();
        for (Marca marca : marcaList) {
            marcaResponses.add(convertToEntity2DTO(marca));
        }
        return marcaResponses;
    }
}
