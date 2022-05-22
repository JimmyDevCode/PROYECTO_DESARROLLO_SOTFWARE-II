package com.ferrosac.mapper;

import com.ferrosac.dto.request.MarcaRequest;
import com.ferrosac.entity.Marca;
import org.springframework.beans.BeanUtils;

//recibo un dto y lo convierto a entity para ser guardada
public class DtoMapper {

    public static Marca converToDTO2Entity(MarcaRequest marcaRequest){

        Marca marca = new Marca();
        BeanUtils.copyProperties(marcaRequest, marca);
        return marca;
    }
}
