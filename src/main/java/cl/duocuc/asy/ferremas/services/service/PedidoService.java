package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.Pedido;

public interface PedidoService {
    Pedido findById(Long id);

    Pedido crearPedido(Pedido pedido);

    Pedido actualizarPedido(Pedido pedido);

    void eliminarPedido(Long id);

    Iterable<Pedido> findAll();

    Pedido findByUsuarioId(Long usuarioId);

    Pedido findBySucursalId(Long sucursalId);
}
