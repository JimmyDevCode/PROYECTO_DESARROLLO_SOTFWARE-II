package com.ferrosac.controller;

import com.ferrosac.dto.request.ProveedorRequest;
import com.ferrosac.dto.response.ProveedorResponse;
import com.ferrosac.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class ProveedorController {

    @Autowired
    IProveedorService iProveedorService;

    @PostMapping("/proveedores")
    public ResponseEntity<ProveedorResponse> save(@RequestBody ProveedorRequest proveedorRequest) {
        ProveedorResponse proveedorResponse = iProveedorService.save(proveedorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedorResponse);
    }

    @GetMapping("/proveedores")
    public ResponseEntity<List<ProveedorResponse>> getAll() {
        List<ProveedorResponse> proveedorResponse = iProveedorService.getAllProveedores();
        return ResponseEntity.status(HttpStatus.OK).body(proveedorResponse);
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<ProveedorResponse> update(@PathVariable("id") Long id, @RequestBody ProveedorRequest proveedorRequest) {
        ProveedorResponse proveedorResponse = iProveedorService.update(id, proveedorRequest);
        return ResponseEntity.status(HttpStatus.OK).body(proveedorResponse);
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iProveedorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
