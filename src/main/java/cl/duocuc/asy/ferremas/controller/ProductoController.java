package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.dto.ProductoCreateDTO;
import cl.duocuc.asy.ferremas.dto.ProductoResponseDTO;
import cl.duocuc.asy.ferremas.dto.ProductoStockUpdateDTO;
import cl.duocuc.asy.ferremas.dto.ProductoPatchDTO;
import cl.duocuc.asy.ferremas.dto.ProductoInactivoDTO;

import cl.duocuc.asy.ferremas.model.Categoria;
import cl.duocuc.asy.ferremas.model.Producto;
import cl.duocuc.asy.ferremas.model.SubCategoria;
import cl.duocuc.asy.ferremas.model.Precio;
import cl.duocuc.asy.ferremas.services.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Productos", description = "Operaciones para gestión de productos, consulta, creación, actualización, eliminación y consulta de precios históricos.")
@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final cl.duocuc.asy.ferremas.services.service.CategoriaService categoriaService;
    private final cl.duocuc.asy.ferremas.services.service.SubCategoriaService subCategoriaService;
    private final cl.duocuc.asy.ferremas.services.service.PrecioService precioService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos activos", description = "Devuelve una lista de todos los productos que están activos.")
    public List<ProductoResponseDTO> getAll() {
        return productoService.findAll().stream()
                .filter(Producto::isActivo) // Solo productos activos
                .map(producto -> {
                    ProductoResponseDTO dto = new ProductoResponseDTO();
                    dto.setId(producto.getId());
                    dto.setCodProducto(producto.getCodProducto());
                    dto.setNombre(producto.getNombre());
                    dto.setDescripcion(producto.getDescripcion());
                    dto.setMarca(producto.getMarca());
                    dto.setStock(producto.getStock());
                    dto.setOferta(producto.isOferta());
                    dto.setNuevo(producto.isNuevo());
                    dto.setImagenUrl(producto.getImagenUrl());
                    dto.setCategoriaId(producto.getCategoria() != null ? producto.getCategoria().getId() : null);
                    dto.setSubCategoriaId(
                            producto.getSubCategoria() != null ? producto.getSubCategoria().getId() : null);
                    if (producto.getPrecios() != null && !producto.getPrecios().isEmpty()) {
                        dto.setPrecioActual(
                                producto.getPrecios().stream()
                                        .filter(Precio::isActivo)
                                        .findFirst()
                                        .map(Precio::getValor)
                                        .orElse(null));
                    } else {
                        dto.setPrecioActual(null);
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Operation(summary = "Crear un nuevo producto", description = "Registra un nuevo producto con su categoría, subcategoría (opcional) y precio inicial.")
    @PostMapping
    public Producto create(@RequestBody ProductoCreateDTO dto) {
        Categoria categoria = categoriaService.buscarPorId(dto.getCategoriaId());
        if (categoria == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoría no encontrada");
        }

        SubCategoria subCategoria = null;
        if (dto.getSubCategoriaId() != null) {
            subCategoria = subCategoriaService.buscarPorId(dto.getSubCategoriaId());
        }

        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .marca(dto.getMarca())
                .stock(dto.getStock())
                .imagenUrl(dto.getImagenUrl())
                .categoria(categoria)
                .subCategoria(subCategoria)
                .oferta(dto.getOferta() != null ? dto.getOferta() : false)
                .activo(true)
                .build();

        Producto savedProducto = productoService.crearProducto(producto);

        if (dto.getPrecio() != null) {
            // Desactivar precios anteriores y registrar el nuevo como activo
            List<Precio> preciosAnteriores = precioService.findByProductoId(savedProducto.getId());
            preciosAnteriores.forEach(p -> {
                if (p.isActivo()) {
                    p.setActivo(false);
                    precioService.actualizarPrecio(p);
                }
            });

            Precio precio = Precio.builder()
                    .fecha(java.time.LocalDateTime.now())
                    .valor(dto.getPrecio())
                    .producto(savedProducto)
                    .activo(true)
                    .build();
            precioService.crearPrecio(precio);
        } else {
            throw new IllegalArgumentException("El precio es obligatorio al crear un producto.");
        }

        return savedProducto;
    }

    @Operation(summary = "Buscar producto por ID", description = "Busca un producto por su ID único.")
    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> getByCategoria(@PathVariable Long categoriaId) {
        return productoService.findByCategoriaId(categoriaId);
    }

    @Operation(summary = "Buscar producto por código", description = "Busca un producto por su código único (codProducto).")
    @GetMapping("/codigo/{codProducto}")
    public ProductoResponseDTO getByCodProducto(@PathVariable String codProducto) {
        return productoService.findByCodProducto(codProducto).map(producto -> {
            ProductoResponseDTO dto = new ProductoResponseDTO();
            dto.setId(producto.getId());
            dto.setCodProducto(producto.getCodProducto());
            dto.setNombre(producto.getNombre());
            dto.setDescripcion(producto.getDescripcion());
            dto.setMarca(producto.getMarca());
            dto.setStock(producto.getStock());
            dto.setImagenUrl(producto.getImagenUrl());
            dto.setCategoriaId(producto.getCategoria() != null ? producto.getCategoria().getId() : null);
            dto.setSubCategoriaId(producto.getSubCategoria() != null ? producto.getSubCategoria().getId() : null);
            dto.setPrecioActual(
                    precioService.findPrecioActivoByProductoId(producto.getId())
                            .map(Precio::getValor)
                            .orElse(null));
            return dto;
        }).orElse(null);
    }

    @Operation(summary = "Buscar productos por subcategoría o categoría", description = "Busca productos por ID de subcategoría o categoría. Si se proporciona subcategoría, se prioriza esa búsqueda. Si no hay productos en la subcategoría, se busca por categoría.")
    @GetMapping("/buscar")
    public List<ProductoResponseDTO> getBySubCategoriaOrCategoria(
            @RequestParam(required = false) Long subCategoriaId,
            @RequestParam Long categoriaId) {
        List<Producto> productos;
        if (subCategoriaId != null) {
            productos = productoService.findBySubCategoriaId(subCategoriaId);
            if (productos.isEmpty()) {
                // Fallback a categoría si no hay productos en la subcategoría
                productos = productoService.findByCategoriaId(categoriaId);
            }
        } else {
            productos = productoService.findByCategoriaId(categoriaId);
        }
        return productos.stream().map(producto -> {
            ProductoResponseDTO dto = new ProductoResponseDTO();
            dto.setId(producto.getId());
            dto.setCodProducto(producto.getCodProducto());
            dto.setNombre(producto.getNombre());
            dto.setDescripcion(producto.getDescripcion());
            dto.setMarca(producto.getMarca());
            dto.setStock(producto.getStock());
            dto.setImagenUrl(producto.getImagenUrl());
            dto.setCategoriaId(producto.getCategoria() != null ? producto.getCategoria().getId() : null);
            dto.setSubCategoriaId(producto.getSubCategoria() != null ? producto.getSubCategoria().getId() : null);
            dto.setPrecioActual(
                    precioService.findPrecioActivoByProductoId(producto.getId())
                            .map(Precio::getValor)
                            .orElse(null));
            return dto;
        }).collect(Collectors.toList());
    }

    @PatchMapping("/codigo/{codProducto}/stock")
    @Operation(summary = "Actualizar stock de producto por código", description = "Actualiza solo el stock del producto identificado por codProducto.")
    public ProductoResponseDTO updateStock(
            @PathVariable String codProducto,
            @RequestBody ProductoStockUpdateDTO stockUpdateDTO) {
        Producto producto = productoService.findByCodProducto(codProducto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
        producto.setStock(stockUpdateDTO.getStock());
        Producto actualizado = productoService.actualizarProducto(producto);

        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(actualizado.getId());
        dto.setCodProducto(actualizado.getCodProducto());
        dto.setNombre(actualizado.getNombre());
        dto.setDescripcion(actualizado.getDescripcion());
        dto.setMarca(actualizado.getMarca());
        dto.setStock(actualizado.getStock());
        dto.setImagenUrl(actualizado.getImagenUrl());
        dto.setCategoriaId(actualizado.getCategoria() != null ? actualizado.getCategoria().getId() : null);
        dto.setSubCategoriaId(actualizado.getSubCategoria() != null ? actualizado.getSubCategoria().getId() : null);
        dto.setPrecioActual(
                precioService.findPrecioActivoByProductoId(actualizado.getId())
                        .map(Precio::getValor)
                        .orElse(null));
        return dto;
    }

    @Operation(summary = "Actualizar por cod producto", description = "Actualizar datos del producto")
    @PatchMapping("/codigo/{codProducto}")
    public ProductoResponseDTO patchProducto(
            @PathVariable String codProducto,
            @RequestBody ProductoPatchDTO patchDTO) {
        Producto producto = productoService.findByCodProducto(codProducto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        if (patchDTO.getNombre() != null)
            producto.setNombre(patchDTO.getNombre());
        if (patchDTO.getDescripcion() != null)
            producto.setDescripcion(patchDTO.getDescripcion());
        if (patchDTO.getMarca() != null)
            producto.setMarca(patchDTO.getMarca());
        if (patchDTO.getStock() != null)
            producto.setStock(patchDTO.getStock());
        if (patchDTO.getImagenUrl() != null)
            producto.setImagenUrl(patchDTO.getImagenUrl());
        if (patchDTO.getOferta() != null)
            producto.setOferta(patchDTO.getOferta());
        if (patchDTO.getNuevo() != null)
            producto.setNuevo(patchDTO.getNuevo());
        if (patchDTO.getActivo() != null)
            producto.setActivo(patchDTO.getActivo());

        Producto actualizado = productoService.actualizarProducto(producto);

        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(actualizado.getId());
        dto.setCodProducto(actualizado.getCodProducto());
        dto.setNombre(actualizado.getNombre());
        dto.setDescripcion(actualizado.getDescripcion());
        dto.setMarca(actualizado.getMarca());
        dto.setStock(actualizado.getStock());
        dto.setImagenUrl(actualizado.getImagenUrl());
        dto.setCategoriaId(actualizado.getCategoria() != null ? actualizado.getCategoria().getId() : null);
        dto.setSubCategoriaId(actualizado.getSubCategoria() != null ? actualizado.getSubCategoria().getId() : null);
        dto.setPrecioActual(
                precioService.findPrecioActivoByProductoId(actualizado.getId())
                        .map(Precio::getValor)
                        .orElse(null));
        return dto;
    }

    @DeleteMapping("/codigo/{codProducto}")
    @Operation(summary = "Borrado lógico de producto por código", description = "Marca el producto como inactivo (activo = false) usando el codProducto.")
    public void deleteByCodProducto(@PathVariable String codProducto) {
        Producto producto = productoService.findByCodProducto(codProducto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
        producto.setActivo(false);
        productoService.actualizarProducto(producto);
    }

    @Operation(summary = "Traer lista de productos inactivos", description = "Trae lista completa de items inactivos de productos")
    @GetMapping("/inactivos")
    public List<ProductoInactivoDTO> getProductosInactivos() {
        return productoService.findAll().stream()
                .filter(producto -> !producto.isActivo())
                .map(producto -> {
                    ProductoInactivoDTO dto = new ProductoInactivoDTO();
                    dto.setCodProducto(producto.getCodProducto());
                    dto.setNombre(producto.getNombre());
                    dto.setActivo(producto.isActivo());
                    return dto;
                })
                .toList();
    }
}