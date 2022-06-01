package com.ferrosac.auth.service.impl;


import com.ferrosac.auth.config.ApplicationRol;
import com.ferrosac.auth.config.JwtUtils;
import com.ferrosac.auth.dto.request.UsuarioAuthenticationRequest;
import com.ferrosac.auth.dto.request.UsuarioDetailsRequest;
import com.ferrosac.auth.dto.response.ListUsuarioResponse;
import com.ferrosac.auth.dto.response.UsuarioAuthenticatedResponse;
import com.ferrosac.auth.dto.response.UsuarioDetailsResponse;
import com.ferrosac.auth.entity.Rol;
import com.ferrosac.auth.entity.Usuario;
import com.ferrosac.auth.exception.UsuarioAlreadyExistException;
import com.ferrosac.auth.mapper.UsuarioMapper;
import com.ferrosac.auth.repository.IRolRepository;
import com.ferrosac.auth.repository.IUsuarioRepository;
import com.ferrosac.auth.service.IRolService;
import com.ferrosac.auth.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

    private static final String USER_NOT_FOUND_MESSAGE = "Usuario no encontrado.";
    private static final String USER_EMAIL_ERROR = "Este nombre de usuario ya está siendo usado.";

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private IUsuarioRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRolRepository rolRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioMapper usuarioMapper;


    @Override
    public UsuarioDetailsResponse register(UsuarioDetailsRequest userDetailsRequest)
            throws UsuarioAlreadyExistException {
        if (userRepository.findByUsername(userDetailsRequest.getUsername()) != null) {
            throw new UsuarioAlreadyExistException(USER_EMAIL_ERROR);
        }

        Usuario user = usuarioMapper.convertToDTO2Entity(userDetailsRequest);
        user.setPassword(passwordEncoder.encode(userDetailsRequest.getPassword()));
        List<Rol> roles = new ArrayList<>();
        roles.add(rolRepository.findByNombre(userDetailsRequest.getRol()));
        user.setRoles(roles); //TODO queda pendiente terminar el registro
        Usuario usuarioCreated = userRepository.save(user);
        UsuarioDetailsResponse usuarioDetailsResponse = usuarioMapper.convertToEntity2DTO(usuarioCreated);
        usuarioDetailsResponse.setToken(jwtUtils.generateToken(usuarioCreated));

        return usuarioDetailsResponse;
    }

    @Override
    public Usuario getBy(String authorizationHeader) {
        return getUser(jwtUtils.extractUsername(authorizationHeader));
    }

    @Override
    public ListUsuarioResponse list() {
        List<Usuario> users = userRepository.findAll();
        return usuarioMapper.convertToEntity2DTOList(users);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        this.userRepository.deleteById(id);
    }

    @Override
    public UsuarioAuthenticatedResponse authentication(
            UsuarioAuthenticationRequest userAuthenticationRequest) {

            Usuario user = getUser(userAuthenticationRequest.getUsername());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthenticationRequest.getUsername(),
                            userAuthenticationRequest.getPassword()));

            return new UsuarioAuthenticatedResponse(jwtUtils.generateToken(user), user.getUsername());

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUser(username);
    }

    private Usuario getUser(Long id) {
        Optional<Usuario> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return userOptional.get();
    }

    private Usuario getUser(String username) {
        Usuario user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return user;
    }

}
