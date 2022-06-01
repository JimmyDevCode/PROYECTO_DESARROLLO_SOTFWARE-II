package com.ferrosac.auth.controller;

import com.ferrosac.auth.dto.request.UsuarioAuthenticationRequest;
import com.ferrosac.auth.dto.request.UsuarioDetailsRequest;
import com.ferrosac.auth.dto.response.UsuarioAuthenticatedResponse;
import com.ferrosac.auth.dto.response.UsuarioDetailsResponse;
import com.ferrosac.auth.exception.UsuarioAlreadyExistException;
import com.ferrosac.auth.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("auth")
public class UsuarioController {

    @Autowired
    IUsuarioService iUsuarioService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioAuthenticatedResponse> login(
            @Valid @RequestBody UsuarioAuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(iUsuarioService.authentication(authenticationRequest));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UsuarioDetailsResponse> register(
            @Valid @RequestBody UsuarioDetailsRequest userDetailsRequest)
            throws UsuarioAlreadyExistException {
        UsuarioDetailsResponse userDetailsResponse = iUsuarioService.register(userDetailsRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsResponse);
    }

}
