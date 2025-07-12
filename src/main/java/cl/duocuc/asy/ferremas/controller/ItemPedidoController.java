package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.ItemPedido;
import cl.duocuc.asy.ferremas.services.service.ItemPedidoService;
import cl.duocuc.asy.ferremas.services.service.PrecioService;
import cl.duocuc.asy.ferremas.dto.ItemPedidoResponseDTO;
import cl.duocuc.asy.ferremas.dto.ProductoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "ItemPedidos", description = "Gestión de ítems de pedidos: crear, actualizar, eliminar y consultar ítems por ID, pedido o producto.")
@RestController
@RequestMapping("/api/itempedidos")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;
    private final PrecioService precioService; // Agregar esta dependencia

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

    @Operation(summary = "Obtener todos los ítems de pedido por ID de pedido", description = "Devuelve todos los ítems de pedido asociados a un pedido específico por su ID.")
    @GetMapping("/pedido/{pedidoId}")
    public List<ItemPedidoResponseDTO> getByPedidoId(@PathVariable Long pedidoId) {
        return itemPedidoService.findByPedidoId(pedidoId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private ItemPedidoResponseDTO toResponseDTO(ItemPedido item) {
        ItemPedidoResponseDTO dto = new ItemPedidoResponseDTO();
        dto.setId(item.getId());
        dto.setCantidad(item.getCantidad());
        dto.setPedidoId(item.getPedido() != null ? item.getPedido().getId() : null);

        if (item.getProducto() != null) {
            ProductoResponseDTO productoDTO = new ProductoResponseDTO();
            productoDTO.setId(item.getProducto().getId());
            productoDTO.setCodProducto(item.getProducto().getCodProducto());
            productoDTO.setNombre(item.getProducto().getNombre());
            productoDTO.setDescripcion(item.getProducto().getDescripcion());
            productoDTO.setMarca(item.getProducto().getMarca());
            productoDTO.setStock(item.getProducto().getStock());
            productoDTO.setImagenUrl(item.getProducto().getImagenUrl());
            productoDTO.setActivo(item.getProducto().isActivo());
            productoDTO.setOferta(item.getProducto().isOferta());
            productoDTO.setNuevo(item.getProducto().isNuevo());
            productoDTO.setCategoriaId(item.getProducto().getCategoria() != null ? item.getProducto().getCategoria().getId() : null);
            productoDTO.setSubCategoriaId(item.getProducto().getSubCategoria() != null ? item.getProducto().getSubCategoria().getId() : null);
            
            // AGREGAR: Obtener el precio activo del producto
            productoDTO.setPrecioActual(
                precioService.findPrecioActivoByProductoId(item.getProducto().getId())
                    .map(precio -> precio.getValor())
                    .orElse(null)
            );
            
            dto.setProducto(productoDTO);
        }

        return dto;
    }

    @Operation(summary = "Obtener ítem de pedido por ID de producto", description = "Devuelve el ítem de pedido asociado a un producto específico por su ID.")
    @GetMapping("/producto/{productoId}")
    public ItemPedido getByProductoId(@PathVariable Long productoId) {
        return itemPedidoService.findByProductoId(productoId);
    }
}