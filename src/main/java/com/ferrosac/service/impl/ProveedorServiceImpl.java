package com.ferrosac.service.impl;

import com.ferrosac.dto.request.ProveedorRequest;
import com.ferrosac.dto.response.ProveedorResponse;
import com.ferrosac.entity.Proveedor;
import com.ferrosac.exception.ParamNotFound;
import com.ferrosac.mapper.ProveedorMapper;
import com.ferrosac.repository.IProveedorRepository;
import com.ferrosac.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    IProveedorRepository iProveedorRepository;
    @Autowired
    ProveedorMapper proveedorMapper;

    private static final String PROVEEDOR_NOT_FOUND_MESSAGE = "Proveedor no encontrado.";


    @Override
    public ProveedorResponse save(ProveedorRequest proveedorRequest) {
        Proveedor proveedor = proveedorMapper.convertToDTO2Entity(proveedorRequest);
        return proveedorMapper.convertToEntity2DTO(iProveedorRepository.save(proveedor));
    }

    @Override
    public List<ProveedorResponse> getAllProveedores() {
        List<Proveedor> proveedores = iProveedorRepository.findAll();
        return proveedorMapper.convertToEntity2DTOList(proveedores);
    }

    @Override
    public ProveedorResponse update(Long id, ProveedorRequest proveedorRequest) {
        Proveedor proveedor = getProveedor(id);
        proveedor.setRazon_social(proveedorRequest.getRazon_social());
        proveedor.setRuc(proveedorRequest.getRuc());
        proveedor.setDireccion(proveedorRequest.getDireccion());
        proveedor.setIdDistrito(proveedorRequest.getIdDistrito());
        return proveedorMapper.convertToEntity2DTO(iProveedorRepository.save(proveedor));
    }

    @Override
    public void delete(Long id) {
        this.iProveedorRepository.deleteById(id);
    }

    private Proveedor getProveedor(Long id) {
        Optional<Proveedor> proveedorOptional = iProveedorRepository.findById(id);
        if (proveedorOptional.isEmpty()) {
            throw new ParamNotFound(PROVEEDOR_NOT_FOUND_MESSAGE);
        }
        return proveedorOptional.get();
    }
}
