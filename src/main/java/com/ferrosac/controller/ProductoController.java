package com.ferrosac.controller;

import com.ferrosac.dto.request.ProductoRequest;
import com.ferrosac.dto.response.ProductoResponse;
import com.ferrosac.entity.Producto;
import com.ferrosac.service.IProductoService;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("api")
public class ProductoController {

    @Autowired
    IProductoService iProductoService;

    @PostMapping("/productos")
    public ResponseEntity<ProductoResponse> save(@RequestBody ProductoRequest productoRequest) {
        ProductoResponse productoResponse = iProductoService.save(productoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoResponse);
    }

    @GetMapping("/productos")
    public ResponseEntity<List<ProductoResponse>> getAll() {
        List<ProductoResponse> productoResponse = iProductoService.getAllProductos();
        return ResponseEntity.status(HttpStatus.OK).body(productoResponse);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<ProductoResponse> update(@PathVariable("id") Long id, @RequestBody ProductoRequest productoRequest) {
        ProductoResponse productoResponse = iProductoService.update(id, productoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productoResponse);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iProductoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/productos/stock")
    public ResponseEntity<ProductoResponse> getStock(@RequestParam String nombre) {
        ProductoResponse productoResponse = iProductoService.getStock(nombre);
        return ResponseEntity.status(HttpStatus.OK).body(productoResponse);
    }
}
