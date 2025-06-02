package cl.duocuc.asy.ferremas.services.serviceImpl;

import org.springframework.stereotype.Service;
import cl.duocuc.asy.ferremas.model.Precio;
import cl.duocuc.asy.ferremas.repository.PrecioRepository;
import cl.duocuc.asy.ferremas.services.service.PrecioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PrecioServiceImpl implements PrecioService {
    private final PrecioRepository precioRepository;

    @Override
    public Precio findById(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del precio no puede ser nulo");
        }
        return precioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Precio no encontrado con ID: " + id));
    }

    @Override
    public Precio crearPrecio(Precio precio) {
        if (precio == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El precio no puede ser nulo");
        }
        return precioRepository.save(precio);
    }

    @Override
    public Precio actualizarPrecio(Precio precio) {
        if (precio == null || precio.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El precio o su ID no pueden ser nulos");
        }
        if (!precioRepository.existsById(precio.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El precio con el ID especificado no existe");
        }
        return precioRepository.save(precio);
    }

    @Override
    public void eliminarPrecio(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del precio no puede ser nulo");
        }
        if (!precioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El precio con el ID especificado no existe");
        }
        precioRepository.deleteById(id);
    }

    @Override
    public List<Precio> findByProductoId(Long productoId) {
        if (productoId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del producto no puede ser nulo");
        }
        return precioRepository.findByProductoId(productoId);
    }

    @Override
    public Optional<Precio> findPrecioActivoByProductoId(Long productoId) {
        if (productoId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del producto no puede ser nulo");
        }
        return precioRepository.findByProductoIdAndActivoTrue(productoId);
    }
}
