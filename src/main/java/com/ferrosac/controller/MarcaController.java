package com.ferrosac.controller;

import com.ferrosac.dto.request.MarcaRequest;
import com.ferrosac.dto.response.MarcaResponse;
import com.ferrosac.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api")
public class MarcaController {

    @Autowired
    IMarcaService iMarcaService;

    @PostMapping("/marca")
    public ResponseEntity<MarcaResponse> save(@RequestBody MarcaRequest marcaRequest){
        MarcaResponse marcaResponse = iMarcaService.save(marcaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaResponse);
    }

    @GetMapping("/marcas")
    public ResponseEntity<List<MarcaResponse>> getAll(){
        List<MarcaResponse> marcaResponse = iMarcaService.getAllMarcas();
        return ResponseEntity.status(HttpStatus.OK).body(marcaResponse);
    }

}
