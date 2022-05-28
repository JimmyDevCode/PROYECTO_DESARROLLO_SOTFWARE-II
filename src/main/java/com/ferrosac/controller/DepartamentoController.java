package com.ferrosac.controller;

import com.ferrosac.dto.request.DepartamentoRequest;
import com.ferrosac.dto.response.DepartamentoResponse;
import com.ferrosac.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class DepartamentoController {

    @Autowired
    IDepartamentoService iDepartamentoService;

    @PostMapping("/departamentos")
    public ResponseEntity<DepartamentoResponse> save(@RequestBody DepartamentoRequest categoriaRequest) {
        DepartamentoResponse departamentoResponse = iDepartamentoService.save(categoriaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoResponse);
    }

    @GetMapping("/departamentos")
    public ResponseEntity<List<DepartamentoResponse>> getAll() {
        List<DepartamentoResponse> departamentoResponses = iDepartamentoService.getAllDepartamentos();
        return ResponseEntity.status(HttpStatus.OK).body(departamentoResponses);
    }

    @PutMapping("/departamentos/{id}")
    public ResponseEntity<DepartamentoResponse> update(@PathVariable("id") Long id, @RequestBody DepartamentoRequest departamentoRequest) {
        DepartamentoResponse departamentoResponse = iDepartamentoService.update(id, departamentoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(departamentoResponse);
    }

    @DeleteMapping("/departamentos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iDepartamentoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
