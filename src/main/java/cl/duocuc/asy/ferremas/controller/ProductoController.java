package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.dto.ProductoCreateDTO;
import cl.duocuc.asy.ferremas.dto.ProductoResponseDTO;
import cl.duocuc.asy.ferremas.model.Categoria;
import cl.duocuc.asy.ferremas.model.Producto;
import cl.duocuc.asy.ferremas.model.SubCategoria;
import cl.duocuc.asy.ferremas.model.Precio;
import cl.duocuc.asy.ferremas.services.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final cl.duocuc.asy.ferremas.services.service.CategoriaService categoriaService;
    private final cl.duocuc.asy.ferremas.services.service.SubCategoriaService subCategoriaService;
    private final cl.duocuc.asy.ferremas.services.service.PrecioService precioService;

    @GetMapping
    public List<ProductoResponseDTO> getAll() {
        return productoService.findAll().stream().map(producto -> {
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
            // Obtener el precio activo
            if (producto.getPrecios() != null && !producto.getPrecios().isEmpty()) {
                dto.setPrecioActual(
                    producto.getPrecios().stream()
                        .filter(Precio::isActivo)
                        .findFirst()
                        .map(Precio::getValor)
                        .orElse(null)
                );
            } else {
                dto.setPrecioActual(null);
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductoResponseDTO getById(@PathVariable Long id) {
        return productoService.findProductobyId(id).map(producto -> {
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
            // Obtener el precio activo desde el servicio
            dto.setPrecioActual(
                precioService.findPrecioActivoByProductoId(producto.getId())
                    .map(Precio::getValor)
                    .orElse(null)
            );
            return dto;
        }).orElse(null);
    }

    @PostMapping
    public Producto create(@RequestBody ProductoCreateDTO dto) {
        Categoria categoria = categoriaService.buscarPorId(dto.getCategoriaId());
        SubCategoria subCategoria = subCategoriaService.buscarPorId(dto.getSubCategoriaId());
        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .marca(dto.getMarca())
                .stock(dto.getStock())
                .imagenUrl(dto.getImagenUrl())
                .categoria(categoria)
                .subCategoria(subCategoria)
                .build();

        // Guardar producto primero para obtener el ID
        Producto savedProducto = productoService.crearProducto(producto);

        // Si viene precio, desactivar precios anteriores y registrar el nuevo como activo
        if (dto.getPrecio() != null) {
            List<Precio> preciosAnteriores = precioService.findByProductoId(savedProducto.getId());
            preciosAnteriores.forEach(p -> {
                if (p.isActivo()) {
                    p.setActivo(false);
                    precioService.actualizarPrecio(p);
                }
            });

            Precio precio = Precio.builder()
                    .fecha(LocalDateTime.now())
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

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody ProductoCreateDTO dto) {
        Producto producto = productoService.findProductobyId(id).orElseThrow();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setMarca(dto.getMarca());
        producto.setStock(dto.getStock());
        producto.setImagenUrl(dto.getImagenUrl());
        producto.setCategoria(categoriaService.buscarPorId(dto.getCategoriaId()));
        producto.setSubCategoria(subCategoriaService.buscarPorId(dto.getSubCategoriaId()));
        Producto updatedProducto = productoService.actualizarProducto(producto);

        // Si viene precio, desactivar precios anteriores y registrar el nuevo como activo
        if (dto.getPrecio() != null) {
            List<Precio> preciosAnteriores = precioService.findByProductoId(updatedProducto.getId());
            preciosAnteriores.forEach(p -> {
                if (p.isActivo()) {
                    p.setActivo(false);
                    precioService.actualizarPrecio(p);
                }
            });

            Precio precio = Precio.builder()
                    .fecha(LocalDateTime.now())
                    .valor(dto.getPrecio())
                    .producto(updatedProducto)
                    .activo(true)
                    .build();
            precioService.crearPrecio(precio);
        } else {
            throw new IllegalArgumentException("El precio es obligatorio al actualizar un producto.");
        }

        return updatedProducto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> getByCategoria(@PathVariable Long categoriaId) {
        return productoService.findByCategoriaId(categoriaId);
    }

    @GetMapping("/{id}/precios")
    public List<Precio> getPreciosByProducto(@PathVariable Long id) {
        // Debes agregar el método en PrecioRepository y PrecioService
        return precioService.findByProductoId(id);
    }

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
                    .orElse(null)
            );
            return dto;
        }).orElse(null);
    }
}