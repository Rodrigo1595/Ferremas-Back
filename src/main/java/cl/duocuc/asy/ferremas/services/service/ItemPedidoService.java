package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.ItemPedido;

public interface ItemPedidoService {
    ItemPedido crearItemPedido(ItemPedido itemPedido);

    ItemPedido actualizarItemPedido(ItemPedido itemPedido);

    void eliminarItemPedido(Long id);

    ItemPedido findById(Long id);

    ItemPedido findByPedidoId(Long pedidoId);

    ItemPedido findByProductoId(Long productoId);

    Iterable<ItemPedido> findAll();
}
