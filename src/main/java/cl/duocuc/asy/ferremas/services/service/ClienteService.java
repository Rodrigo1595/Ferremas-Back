package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.Cliente;

public interface ClienteService {

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Cliente cliente);

    void eliminarCliente(Long id);

    Cliente findByClienteId(Long id);

    Cliente findByRutCliente(String rut);

    Cliente findByCorreoCliente(String correo);

}
