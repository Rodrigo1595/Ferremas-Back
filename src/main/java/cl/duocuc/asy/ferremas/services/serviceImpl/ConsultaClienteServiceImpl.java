package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.ConsultaCliente;
import cl.duocuc.asy.ferremas.repository.ConsultaClienteRepository;
import cl.duocuc.asy.ferremas.services.service.ConsultaClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ConsultaClienteServiceImpl implements ConsultaClienteService {

    private final ConsultaClienteRepository consultaClienteRepository;

    @Override
    public ConsultaCliente crearConsulta(ConsultaCliente consulta) {
        return consultaClienteRepository.save(consulta);
    }

    @Override
    public ConsultaCliente actualizarConsulta(ConsultaCliente consultaCliente) {
        // Implement the update logic, e.g., using a repository
        return consultaClienteRepository.save(consultaCliente);
    }

    @Override
    public ConsultaCliente findById(Long id) {
        return consultaClienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta no encontrada"));
    }

    @Override
    public List<ConsultaCliente> findAll() {
        return consultaClienteRepository.findAll();
    }

    @Override
    public List<ConsultaCliente> findByResuelto(boolean resuelto) {
        return consultaClienteRepository.findByResuelto(resuelto);
    }

    @Override
    public List<ConsultaCliente> findByClienteRut(String clienteRut) {
        return consultaClienteRepository.findByClienteRut(clienteRut);
    }

    @Override
    public List<ConsultaCliente> findByClienteCorreo(String correo) {
        return consultaClienteRepository.findByCliente_Correo(correo);
    }

}
