package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.dto.ProductoCreateDTO;
import cl.duocuc.asy.ferremas.model.Categoria;
import cl.duocuc.asy.ferremas.model.Producto;
import cl.duocuc.asy.ferremas.model.SubCategoria;
import cl.duocuc.asy.ferremas.services.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final cl.duocuc.asy.ferremas.services.service.CategoriaService categoriaService;
    private final cl.duocuc.asy.ferremas.services.service.SubCategoriaService subCategoriaService;

    @GetMapping
    public List<Producto> getAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getById(@PathVariable Long id) {
        return productoService.findProductobyId(id);
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
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.actualizarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> getByCategoria(@PathVariable Long categoriaId) {
        return productoService.findByCategoriaId(categoriaId);
    }
}