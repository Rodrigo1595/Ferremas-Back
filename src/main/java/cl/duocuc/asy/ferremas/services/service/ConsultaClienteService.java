package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.ConsultaCliente;
import java.util.List;

public interface ConsultaClienteService {
    ConsultaCliente crearConsulta(ConsultaCliente consulta);
    ConsultaCliente findById(Long id);
    ConsultaCliente actualizarConsulta(ConsultaCliente consultaCliente);
    List<ConsultaCliente> findAll();
    List<ConsultaCliente> findByResuelto(boolean resuelto);
    List<ConsultaCliente> findByClienteRut(String clienteRut);
    List<ConsultaCliente> findByClienteCorreo(String correo);
}
