package cl.duocuc.asy.ferremas.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import cl.duocuc.asy.ferremas.model.Cliente;
import cl.duocuc.asy.ferremas.repository.ClienteRepository;
import cl.duocuc.asy.ferremas.services.service.ClienteService;

@Service
@Transactional
@RequiredArgsConstructor

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    
    @Override
    public Cliente crearCliente(Cliente cliente) {
        if (cliente == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El cliente no puede ser nulo");
        }
        return clienteRepository.save(cliente);
    }
    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        if (cliente == null || cliente.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El cliente o su ID no pueden ser nulos");
        }
        if (!clienteRepository.existsById(cliente.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente con el ID especificado no existe");
        }
        return clienteRepository.save(cliente);
    }
    @Override
    public void eliminarCliente(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del cliente no puede ser nulo");
        }
        if (!clienteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente con el ID especificado no existe");
        }
        clienteRepository.deleteById(id);
    }
    @Override
    public Cliente findByClienteId(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del cliente no puede ser nulo");
        }
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
    }

    @Override
    public Cliente findByRutCliente(String rut) {
        if (rut == null || rut.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El RUT del cliente no puede ser nulo o vacío");
        }
        return clienteRepository.findByRut(rut)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado con el RUT dado"));
    }

    @Override
    public Cliente findByCorreoCliente(String correo) {
        if (correo == null || correo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo del cliente no puede ser nulo o vacío");
        }
        return clienteRepository.findByCorreo(correo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado con el correo dado"));
    }

    
}
