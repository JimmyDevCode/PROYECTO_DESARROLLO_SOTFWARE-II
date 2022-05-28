package com.ferrosac.mapper;

import com.ferrosac.dto.request.ProveedorRequest;
import com.ferrosac.dto.response.ProveedorResponse;
import com.ferrosac.entity.Distrito;
import com.ferrosac.entity.Proveedor;
import com.ferrosac.repository.IDistritoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProveedorMapper {

    @Autowired
    IDistritoRepository iDistritoRepository;

    public Proveedor convertToDTO2Entity(ProveedorRequest proveedorRequest) {
        Proveedor proveedor = new Proveedor();
        BeanUtils.copyProperties(proveedorRequest, proveedor);
        return proveedor;
    }

    public ProveedorResponse convertToEntity2DTO(Proveedor proveedor) {
        ProveedorResponse proveedorResponse = new ProveedorResponse();
        Distrito distrito = iDistritoRepository.getById(proveedor.getIdDistrito());
        proveedorResponse.setDistrito(distrito.getNombre());
        BeanUtils.copyProperties(proveedor, proveedorResponse);
        return proveedorResponse;
    }

    public List<ProveedorResponse> convertToEntity2DTOList(List<Proveedor> proveedorList) {
        List<ProveedorResponse> proveedorResponses = new ArrayList<>();
        for (Proveedor proveedor: proveedorList) {
            proveedorResponses.add(convertToEntity2DTO(proveedor));
        }
        return proveedorResponses;
    }

}
