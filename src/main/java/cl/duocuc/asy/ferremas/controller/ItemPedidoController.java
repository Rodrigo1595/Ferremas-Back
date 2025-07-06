package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.ItemPedido;
import cl.duocuc.asy.ferremas.services.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "ItemPedidos", description = "Gestión de ítems de pedidos: crear, actualizar, eliminar y consultar ítems por ID, pedido o producto.")
@RestController
@RequestMapping("/api/itempedidos")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @Operation(summary = "Listar todos los ítems de pedidos", description = "Obtiene el listado completo de todos los ítems de pedidos registrados.")
    @GetMapping
    public Iterable<ItemPedido> getAll() {
        return itemPedidoService.findAll();
    }

    @Operation(summary = "Obtener ítem de pedido por ID", description = "Devuelve los detalles de un ítem de pedido específico según su identificador único.")
    @GetMapping("/{id}")
    public ItemPedido getById(@PathVariable Long id) {
        return itemPedidoService.findById(id);
    }

    @Operation(summary = "Crear un nuevo ítem de pedido", description = "Registra un nuevo ítem de pedido en el sistema.")
    @PostMapping
    public ItemPedido create(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.crearItemPedido(itemPedido);
    }

    @Operation(summary = "Actualizar ítem de pedido", description = "Actualiza los datos de un ítem de pedido existente por su ID.")
    @PutMapping("/{id}")
    public ItemPedido update(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        itemPedido.setId(id);
        return itemPedidoService.actualizarItemPedido(itemPedido);
    }

    @Operation(summary = "Eliminar ítem de pedido", description = "Elimina un ítem de pedido del sistema por su ID.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemPedidoService.eliminarItemPedido(id);
    }

    @Operation(summary = "Obtener ítem de pedido por ID de pedido", description = "Devuelve el ítem de pedido asociado a un pedido específico por su ID.")
    @GetMapping("/pedido/{pedidoId}")
    public ItemPedido getByPedidoId(@PathVariable Long pedidoId) {
        return itemPedidoService.findByPedidoId(pedidoId);
    }

    @Operation(summary = "Obtener ítem de pedido por ID de producto", description = "Devuelve el ítem de pedido asociado a un producto específico por su ID.")
    @GetMapping("/producto/{productoId}")
    public ItemPedido getByProductoId(@PathVariable Long productoId) {
        return itemPedidoService.findByProductoId(productoId);
    }
}