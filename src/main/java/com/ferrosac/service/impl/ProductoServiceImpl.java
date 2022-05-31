package com.ferrosac.service.impl;

import com.ferrosac.dto.request.ProductoRequest;
import com.ferrosac.dto.response.ProductoResponse;
import com.ferrosac.entity.Producto;
import com.ferrosac.exception.ParamNotFound;
import com.ferrosac.mapper.ProductoMapper;
import com.ferrosac.repository.IProductoRepository;
import com.ferrosac.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProductoRepository iProductoRepository;
    @Autowired
    ProductoMapper productoMapper;

    private static final String MARCA_NOT_FOUND_MESSAGE = "Producto no encontrado.";

    @Override
    public ProductoResponse save(ProductoRequest productoRequest) {
        Producto producto = productoMapper.convertToDTO2Entity(productoRequest);
        return productoMapper.convertToEntity2DTO(iProductoRepository.save(producto));
    }

    @Override
    public List<ProductoResponse> getAllProductos() {
        List<Producto> productos = iProductoRepository.findAll();
        return productoMapper.convertToEntity2DTOList(productos);
    }

    @Override
    public ProductoResponse update(Long id, ProductoRequest productoRequest) {
        Producto producto = getProducto(id);
        producto.setCodigo(productoRequest.getCodigo());
        producto.setNombre(productoRequest.getNombre());
        producto.setStock(productoRequest.getStock());
        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setIdCategoria(productoRequest.getIdCategoria());
        producto.setIdMarca(productoRequest.getIdMarca());

        return productoMapper.convertToEntity2DTO(iProductoRepository.save(producto));
    }

    @Override
    public ProductoResponse getStock(String nombre) {
        Producto producto = iProductoRepository.findByNombre(nombre);
        return productoMapper.convertToEntity2DTOStock(producto);
    }

    @Override
    public void delete(Long id) {
        this.iProductoRepository.deleteById(id);
    }

    private Producto getProducto(Long id) {
        Optional<Producto> productoOptional = iProductoRepository.findById(id);
        if (productoOptional.isEmpty()) {
            throw new ParamNotFound(MARCA_NOT_FOUND_MESSAGE);
        }
        return productoOptional.get();
    }
}
