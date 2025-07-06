package cl.duocuc.asy.ferremas.services.service;

import java.util.List;

import cl.duocuc.asy.ferremas.model.Pedido;

public interface PedidoService {
    Pedido findById(Long id);

    Pedido crearPedido(Pedido pedido);

    Pedido actualizarPedido(Pedido pedido);

    void eliminarPedido(Long id);

    Iterable<Pedido> findAll();

    List<Pedido> findByCorreoCliente(String correo);

    Pedido findBySucursalId(Long sucursalId);
}
