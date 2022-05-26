package com.ferrosac.mapper;

import com.ferrosac.dto.request.ProductoRequest;
import com.ferrosac.dto.response.ProductoResponse;
import com.ferrosac.entity.Categoria;
import com.ferrosac.entity.Marca;
import com.ferrosac.entity.Producto;
import com.ferrosac.exception.ParamNotFound;
import com.ferrosac.repository.ICategoriaRepository;
import com.ferrosac.repository.IMarcaRepository;
import com.ferrosac.repository.IProductoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoMapper {

    @Autowired
    IMarcaRepository iMarcaRepository;
    @Autowired
    ICategoriaRepository iCategoriaRepository;

    public Producto convertToDTO2Entity(ProductoRequest productoRequest) {
        Producto producto = new Producto();
        BeanUtils.copyProperties(productoRequest, producto);
        return producto;
    }

    public ProductoResponse convertToEntity2DTO(Producto producto) {
        ProductoResponse productoResponse = new ProductoResponse();
        Marca marca = iMarcaRepository.getById(producto.getIdMarca());
        Categoria categoria = iCategoriaRepository.getById(producto.getIdCategoria());
        productoResponse.setMarca(marca.getNombre());
        productoResponse.setCategoria(categoria.getNombre());
        BeanUtils.copyProperties(producto, productoResponse);
        return productoResponse;
    }

    public List<ProductoResponse> convertToEntity2DTOList(List<Producto> productoList) {
        List<ProductoResponse> productoResponses = new ArrayList<>();
        for (Producto producto: productoList) {
            productoResponses.add(convertToEntity2DTO(producto));
        }
        return productoResponses;
    }

}
