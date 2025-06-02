package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.Precio;
import java.util.List;
import java.util.Optional;

public interface PrecioService {
    Precio findById(Long id);
    Precio crearPrecio(Precio precio);
    Precio actualizarPrecio(Precio precio);
    void eliminarPrecio(Long id);
    List<Precio> findByProductoId(Long productoId);
    Optional<Precio> findPrecioActivoByProductoId(Long productoId);
}
