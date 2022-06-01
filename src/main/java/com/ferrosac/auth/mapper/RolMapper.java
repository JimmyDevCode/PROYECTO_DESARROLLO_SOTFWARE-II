package com.ferrosac.auth.mapper;

import com.ferrosac.auth.dto.response.RolResponse;
import com.ferrosac.auth.entity.Rol;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RolMapper {

    public RolResponse convertToEntity2DTO(Rol role) {
        RolResponse roleResponse = new RolResponse();
        roleResponse.setNombre(role.getNombre());
        return roleResponse;
    }

    public List<RolResponse> convertToEntity2DTOList(List<Rol> roles) {
        List<RolResponse> roleResponses = new ArrayList<>();
        for (Rol role : roles) {
            roleResponses.add(convertToEntity2DTO(role));
        }
        return roleResponses;
    }
}
