package com.ferrosac.auth.service;


import com.ferrosac.auth.dto.request.UsuarioAuthenticationRequest;
import com.ferrosac.auth.dto.request.UsuarioDetailsRequest;
import com.ferrosac.auth.dto.response.ListUsuarioResponse;
import com.ferrosac.auth.dto.response.UsuarioAuthenticatedResponse;
import com.ferrosac.auth.dto.response.UsuarioDetailsResponse;
import com.ferrosac.auth.entity.Usuario;
import com.ferrosac.auth.exception.UsuarioAlreadyExistException;

import javax.persistence.EntityNotFoundException;

public interface IUsuarioService {

    UsuarioDetailsResponse register(UsuarioDetailsRequest userDetailsRequest)
            throws UsuarioAlreadyExistException;

    Usuario getBy(String authorizationHeader);

    ListUsuarioResponse list();

    void delete(Long id) throws EntityNotFoundException;

    UsuarioAuthenticatedResponse authentication(UsuarioAuthenticationRequest authRequest);
}
