package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Pedido;
import cl.duocuc.asy.ferremas.services.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@Tag(name = "Pedidos", description = "Gestión de pedidos: crear, actualizar, eliminar y consultar pedidos por cliente o sucursal.")
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

    @GetMapping("/clientes/{correoCliente}")
    public List<Pedido> getByCorreoClientePedidos(@PathVariable String correo) {
        return pedidoService.findByClienteCorreoPedido(correo);
    }

    @GetMapping("/sucursal/{sucursalId}")
    public Pedido getBySucursalId(@PathVariable Long sucursalId) {
        return pedidoService.findBySucursalId(sucursalId);
    }
}
