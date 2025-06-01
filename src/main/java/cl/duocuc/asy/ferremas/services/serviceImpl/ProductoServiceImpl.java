package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.Producto;
import cl.duocuc.asy.ferremas.repository.ProductoRepository;
import cl.duocuc.asy.ferremas.services.service.ProductoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor

public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        Long count = productoRepository.count() + 1;
        String cod = String.format("FER-%06d", count);
        producto.setCodProducto(cod);
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del producto no puede ser nulo");
        }
        if (!productoRepository.existsById(id)) {
            throw new IllegalArgumentException("El producto con el ID especificado no existe");
        }
        productoRepository.deleteById(id);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        if (producto == null || producto.getId() == null) {
            throw new IllegalArgumentException("El producto o su ID no pueden ser nulos");
        }
        if (!productoRepository.existsById(producto.getId())) {
            throw new IllegalArgumentException("El producto con el ID especificado no existe");
        }
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findByCategoriaId(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    @Override
    public Optional<Producto> findProductobyId(Long id) {
        return productoRepository.findById(id);
    }

}
