package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.ItemPedido;
import cl.duocuc.asy.ferremas.services.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/itempedidos")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @GetMapping
    public Iterable<ItemPedido> getAll() {
        return itemPedidoService.findAll();
    }

    @GetMapping("/{id}")
    public ItemPedido getById(@PathVariable Long id) {
        return itemPedidoService.findById(id);
    }

    @PostMapping
    public ItemPedido create(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.crearItemPedido(itemPedido);
    }

    @PutMapping("/{id}")
    public ItemPedido update(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        itemPedido.setId(id);
        return itemPedidoService.actualizarItemPedido(itemPedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemPedidoService.eliminarItemPedido(id);
    }

    @GetMapping("/pedido/{pedidoId}")
    public ItemPedido getByPedidoId(@PathVariable Long pedidoId) {
        return itemPedidoService.findByPedidoId(pedidoId);
    }

    @GetMapping("/producto/{productoId}")
    public ItemPedido getByProductoId(@PathVariable Long productoId) {
        return itemPedidoService.findByProductoId(productoId);
    }
}