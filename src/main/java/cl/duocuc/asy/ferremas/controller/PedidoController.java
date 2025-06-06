package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Pedido;
import cl.duocuc.asy.ferremas.services.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Listar todos los pedidos", description = "Obtiene el listado completo de todos los pedidos registrados.")
    @GetMapping
    public Iterable<Pedido> getAll() {
        return pedidoService.findAll();
    }

    @Operation(summary = "Obtener pedido por ID", description = "Devuelve los detalles de un pedido específico según su identificador único.")
    @GetMapping("/{id}")
    public Pedido getById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @Operation(summary = "Crear un nuevo pedido", description = "Registra un nuevo pedido en el sistema.")
    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    @Operation(summary = "Actualizar pedido", description = "Actualiza los datos de un pedido existente por su ID.")
    @PutMapping("/{id}")
    public Pedido update(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoService.actualizarPedido(pedido);
    }

    @Operation(summary = "Eliminar pedido", description = "Elimina un pedido del sistema por su ID.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
    }

    @Operation(summary = "Listar pedidos por correo de cliente", description = "Obtiene todos los pedidos asociados al correo del cliente.")
    @GetMapping("/clientes/{correo}")
    public List<Pedido> getByCorreoClientePedidos(@PathVariable String correo) {
        return pedidoService.findByCorreoCliente(correo);
    }

    @Operation(summary = "Obtener pedido por sucursal", description = "Devuelve el pedido asociado a una sucursal específica por su ID.")
    @GetMapping("/sucursal/{sucursalId}")
    public Pedido getBySucursalId(@PathVariable Long sucursalId) {
        return pedidoService.findBySucursalId(sucursalId);
    }
}
