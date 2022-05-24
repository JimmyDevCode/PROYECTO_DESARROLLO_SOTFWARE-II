package com.ferrosac.mapper;

import com.ferrosac.dto.request.MarcaRequest;
import com.ferrosac.dto.response.MarcaResponse;
import com.ferrosac.entity.Marca;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

//recibo una entidad y lo convierto a dto para ser mostrada
public class EntityMapper {

    public static MarcaResponse converToEntity2DTO(Marca marca){
        MarcaResponse marcaResponse = new MarcaResponse();
        BeanUtils.copyProperties(marca, marcaResponse);
        return marcaResponse;
    }

    public static List<MarcaResponse> converToEntity2DTOList(List<Marca> marcaList){
        List<MarcaResponse> marcaResponses = new ArrayList<>();
        for(Marca marca: marcaList){
            marcaResponses.add(converToEntity2DTO(marca));
        }
        return  marcaResponses;
    }


}
