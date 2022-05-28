package com.ferrosac.controller;

import com.ferrosac.dto.request.CiudadRequest;
import com.ferrosac.dto.response.CiudadResponse;
import com.ferrosac.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class CiudadController {

    @Autowired
    ICiudadService iCiudadService;

    @PostMapping("/ciudades")
    public ResponseEntity<CiudadResponse> save(@RequestBody CiudadRequest ciudadRequest) {
        CiudadResponse ciudadResponse = iCiudadService.save(ciudadRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudadResponse);
    }

    @GetMapping("/ciudades")
    public ResponseEntity<List<CiudadResponse>> getAll() {
        List<CiudadResponse> ciudadResponse = iCiudadService.getAllCiudades();
        return ResponseEntity.status(HttpStatus.OK).body(ciudadResponse);
    }

    @PutMapping("/ciudades/{id}")
    public ResponseEntity<CiudadResponse> update(@PathVariable("id") Long id, @RequestBody CiudadRequest ciudadRequest) {
        CiudadResponse productoResponse = iCiudadService.update(id, ciudadRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productoResponse);
    }

    @DeleteMapping("/ciudades/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iCiudadService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
