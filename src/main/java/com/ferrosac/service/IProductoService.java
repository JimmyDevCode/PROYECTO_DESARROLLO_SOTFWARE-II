package com.ferrosac.service;

import com.ferrosac.dto.request.ProductoRequest;
import com.ferrosac.dto.response.ProductoResponse;

import java.util.List;

public interface IProductoService {

    ProductoResponse save(ProductoRequest productoRequest);

    List<ProductoResponse> getAllProductos();

    ProductoResponse update(Long id, ProductoRequest productoRequest);

    ProductoResponse getStock(String nombre);

    void delete(Long id);
}
