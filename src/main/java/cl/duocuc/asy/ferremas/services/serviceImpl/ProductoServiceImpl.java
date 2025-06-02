package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.Producto;
import cl.duocuc.asy.ferremas.repository.ProductoRepository;
import cl.duocuc.asy.ferremas.services.service.ProductoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El producto no puede ser nulo");
        }
        Long count = productoRepository.count() + 1;
        String cod = String.format("FER-%06d", count);
        producto.setCodProducto(cod);
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del producto no puede ser nulo");
        }
        if (!productoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El producto con el ID especificado no existe");
        }
        productoRepository.deleteById(id);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        if (producto == null || producto.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El producto o su ID no pueden ser nulos");
        }
        if (!productoRepository.existsById(producto.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El producto con el ID especificado no existe");
        }
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findByCategoriaId(Long categoriaId) {
        if (categoriaId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID de la categoría no puede ser nulo");
        }
        return productoRepository.findByCategoriaId(categoriaId);
    }

    @Override
    public Optional<Producto> findProductobyId(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del producto no puede ser nulo");
        }
        return productoRepository.findById(id);
    }

    @Override
    public Optional<Producto> findByCodProducto(String codProducto) {
        if (codProducto == null || codProducto.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El código del producto no puede ser nulo o vacío");
        }
        return productoRepository.findByCodProducto(codProducto);
    }

    @Override
    public List<Producto> findBySubCategoriaId(Long subCategoriaId) {
        if (subCategoriaId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID de la subcategoría no puede ser nulo");
        }
        return productoRepository.findBySubCategoriaId(subCategoriaId);
    }
}
