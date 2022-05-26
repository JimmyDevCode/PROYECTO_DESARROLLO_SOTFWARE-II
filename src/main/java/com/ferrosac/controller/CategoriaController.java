package com.ferrosac.controller;

import com.ferrosac.dto.request.CategoriaRequest;
import com.ferrosac.dto.response.CategoriaResponse;
import com.ferrosac.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api")
public class CategoriaController {

    @Autowired
    ICategoriaService iCategoriaService;

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaResponse> save(@RequestBody CategoriaRequest categoriaRequest) {
        CategoriaResponse categoriaResponse = iCategoriaService.save(categoriaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaResponse);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaResponse>> getAll() {
        List<CategoriaResponse> categoriaResponse = iCategoriaService.getAllCategorias();
        return ResponseEntity.status(HttpStatus.OK).body(categoriaResponse);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponse> update(@PathVariable("id") Long id, @RequestBody CategoriaRequest categoriaRequest) {
        CategoriaResponse categoriaResponse = iCategoriaService.update(id, categoriaRequest);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaResponse);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iCategoriaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
