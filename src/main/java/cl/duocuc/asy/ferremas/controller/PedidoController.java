package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Pedido;
import cl.duocuc.asy.ferremas.services.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public Iterable<Pedido> getAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Pedido getById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoService.actualizarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public Pedido getByUsuarioId(@PathVariable Long usuarioId) {
        return pedidoService.findByUsuarioId(usuarioId);
    }

    @GetMapping("/sucursal/{sucursalId}")
    public Pedido getBySucursalId(@PathVariable Long sucursalId) {
        return pedidoService.findBySucursalId(sucursalId);
    }
}
