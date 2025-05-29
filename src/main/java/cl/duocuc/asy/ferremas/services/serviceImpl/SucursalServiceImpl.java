package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.Sucursal;
import cl.duocuc.asy.ferremas.repository.SucursalRepository;
import cl.duocuc.asy.ferremas.services.service.SucursalService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
@RequiredArgsConstructor

public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private final SucursalRepository sucursalRepository;

    @Override
    public Sucursal buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la sucursal no puede ser nulo");
        }
        return sucursalRepository.findById(id).orElse(null);
    }

    @Override
    public Sucursal crearSucursal(Sucursal sucursal) {
        if (sucursal == null) {
            throw new IllegalArgumentException("La sucursal no puede ser nula");
        }
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal actualizarSucursal(Sucursal sucursal) {
        if (sucursal == null || sucursal.getId() == null) {
            throw new IllegalArgumentException("La sucursal o su ID no pueden ser nulos");
        }
        if (!sucursalRepository.existsById(sucursal.getId())) {
            throw new IllegalArgumentException("La sucursal con el ID especificado no existe");
        }
        return sucursalRepository.save(sucursal);
    }

    @Override
    public void eliminarSucursal(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la sucursal no puede ser nulo");
        }
        if (!sucursalRepository.existsById(id)) {
            throw new IllegalArgumentException("La sucursal con el ID especificado no existe");
        }
        sucursalRepository.deleteById(id);
    }

    @Override
    public Iterable<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

}
