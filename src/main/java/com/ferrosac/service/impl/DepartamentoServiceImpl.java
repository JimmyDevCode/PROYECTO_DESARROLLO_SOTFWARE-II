package com.ferrosac.service.impl;

import com.ferrosac.dto.request.DepartamentoRequest;
import com.ferrosac.dto.response.DepartamentoResponse;
import com.ferrosac.entity.Departamento;
import com.ferrosac.exception.ParamNotFound;
import com.ferrosac.mapper.DepartamentoMapper;
import com.ferrosac.repository.IDepartamentoRepository;
import com.ferrosac.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService {

    private static final String DEPARTAMENTO_NOT_FOUND_MESSAGE = "Departamento no encontrado.";

    @Autowired
    IDepartamentoRepository iDepartamentoRepository;
    @Autowired
    DepartamentoMapper departamentoMapper;

    @Override
    public DepartamentoResponse save(DepartamentoRequest departamentoRequest) {
        Departamento departamento = departamentoMapper.convertToDTO2Entity(departamentoRequest);
        return departamentoMapper.convertToEntity2DTO(iDepartamentoRepository.save(departamento));
    }

    @Override
    public List<DepartamentoResponse> getAllDepartamentos() {
        List<Departamento> departamentos = iDepartamentoRepository.findAll();
        return departamentoMapper.convertToEntity2DTOList(departamentos);
    }

    @Override
    public DepartamentoResponse update(Long id, DepartamentoRequest departamentoRequest) {
        Departamento departamento = getDepartamento(id);
        departamento.setNombre(departamentoRequest.getNombre());
        departamento.setPrefijo(departamentoRequest.getPrefijo());
        return departamentoMapper.convertToEntity2DTO(iDepartamentoRepository.save(departamento));
    }

    @Override
    public void delete(Long id) {
        this.iDepartamentoRepository.deleteById(id);
    }

    private Departamento getDepartamento(Long id) {
        Optional<Departamento> departamentoOptional = iDepartamentoRepository.findById(id);
        if (departamentoOptional.isEmpty()) {
            throw new ParamNotFound(DEPARTAMENTO_NOT_FOUND_MESSAGE);
        }
        return departamentoOptional.get();
    }
}
