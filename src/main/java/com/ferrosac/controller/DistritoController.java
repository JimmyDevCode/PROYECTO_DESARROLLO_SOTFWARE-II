package com.ferrosac.controller;

import com.ferrosac.dto.request.DistritoRequest;
import com.ferrosac.dto.response.DistritoResponse;
import com.ferrosac.service.IDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class DistritoController {

    @Autowired
    IDistritoService iDistritoService;

    @PostMapping("/destritos")
    public ResponseEntity<DistritoResponse> save(@RequestBody DistritoRequest distritoRequest) {
        DistritoResponse distritoResponse = iDistritoService.save(distritoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(distritoResponse);
    }

    @GetMapping("/destritos")
    public ResponseEntity<List<DistritoResponse>> getAll() {
        List<DistritoResponse> distritoResponse = iDistritoService.getAllCiudades();
        return ResponseEntity.status(HttpStatus.OK).body(distritoResponse);
    }

    @PutMapping("/destritos/{id}")
    public ResponseEntity<DistritoResponse> update(@PathVariable("id") Long id, @RequestBody DistritoRequest distritoRequest) {
        DistritoResponse distritoResponse = iDistritoService.update(id, distritoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(distritoResponse);
    }

    @DeleteMapping("/destritos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iDistritoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
