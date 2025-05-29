package cl.duocuc.asy.ferremas.services.serviceImpl;

import org.springframework.stereotype.Service;

import cl.duocuc.asy.ferremas.model.Precio;
import cl.duocuc.asy.ferremas.repository.PrecioRepository;
import cl.duocuc.asy.ferremas.services.service.PrecioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PrecioServiceImpl implements PrecioService {
    private final PrecioRepository precioRepository;

    @Override
    public Precio findById(Long id) {
        return precioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Precio no encontrado con ID: " + id));
    }

    @Override
    public Precio crearPrecio(Precio precio) {
        if (precio == null) {
            throw new IllegalArgumentException("El precio no puede ser nulo");
        }
        return precioRepository.save(precio);
    }

    @Override
    public Precio actualizarPrecio(Precio precio) {
        if (precio == null || precio.getId() == null) {
            throw new IllegalArgumentException("El precio o su ID no pueden ser nulos");
        }
        if (!precioRepository.existsById(precio.getId())) {
            throw new IllegalArgumentException("El precio con el ID especificado no existe");
        }
        return precioRepository.save(precio);
    }

    @Override
    public void eliminarPrecio(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del precio no puede ser nulo");
        }
        if (!precioRepository.existsById(id)) {
            throw new IllegalArgumentException("El precio con el ID especificado no existe");
        }
        precioRepository.deleteById(id);
    }
    
    


}
