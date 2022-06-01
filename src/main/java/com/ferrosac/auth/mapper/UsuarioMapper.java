package com.ferrosac.auth.mapper;

import com.ferrosac.auth.dto.request.UsuarioDetailsRequest;
import com.ferrosac.auth.dto.response.ListUsuarioResponse;
import com.ferrosac.auth.dto.response.UsuarioDetailsResponse;
import com.ferrosac.auth.dto.response.UsuarioResponse;
import com.ferrosac.auth.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {

    @Autowired
    RolMapper rolMapper;

    public Usuario convertToDTO2Entity(UsuarioDetailsRequest usuarioDetailsRequest) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDetailsRequest.getNombre());
        usuario.setApellido(usuarioDetailsRequest.getApellido());
        usuario.setUsername(usuarioDetailsRequest.getUsername());
        return usuario;
    }

    public UsuarioDetailsResponse convertToEntity2DTO(Usuario usuario) {
        UsuarioDetailsResponse usuarioDetailsResponse = new UsuarioDetailsResponse();
        usuarioDetailsResponse.setNombre(usuario.getNombre());
        usuarioDetailsResponse.setApellido(usuario.getApellido());
        usuarioDetailsResponse.setUsername(usuario.getUsername());
        return usuarioDetailsResponse;
    }

    public ListUsuarioResponse convertToEntity2DTOList(List<Usuario> users) {
        List<UsuarioResponse> userResponses = new ArrayList<>();
        for (Usuario user : users) {
            UsuarioResponse userResponse = new UsuarioResponse();
            userResponse.setNombre(user.getNombre());
            userResponse.setApellido(user.getApellido());
            userResponse.setUsername(user.getApellido());
            userResponse.setRoles(rolMapper.convertToEntity2DTOList(user.getRoles()));
            userResponses.add(userResponse);
        }
        return new ListUsuarioResponse(userResponses);
    }
}
