package cl.duocuc.asy.ferremas.services.service;

import java.util.List;
import java.util.Optional;

import cl.duocuc.asy.ferremas.model.Producto;

public interface ProductoService {
    List<Producto> findAll();

    Producto crearProducto(Producto producto);

    void eliminarProducto(Long id);

    Producto actualizarProducto(Producto producto);

    List<Producto> findByCategoriaId(Long categoriaId);

    List<Producto> findBySubCategoriaId(Long subCategoriaId);

    Optional<Producto> findByCodProducto(String codProducto);
}
