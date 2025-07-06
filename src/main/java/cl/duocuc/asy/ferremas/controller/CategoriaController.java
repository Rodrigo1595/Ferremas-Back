package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Categoria;
import cl.duocuc.asy.ferremas.services.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categorías", description = "Gestión de categorías: crear, listar, actualizar y eliminar categorías de productos.")
@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Operation(summary = "Listar todas las categorías", description = "Obtiene el listado completo de todas las categorías registradas.")
    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    @Operation(summary = "Obtener categoría por ID", description = "Devuelve los detalles de una categoría específica según su identificador único.")
    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @Operation(summary = "Crear una nueva categoría", description = "Registra una nueva categoría en el sistema.")
    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.crearCategoria(categoria);
    }

    @Operation(summary = "Actualizar categoría", description = "Actualiza los datos de una categoría existente por su ID.")
    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        return categoriaService.actualizarCategoria(categoria);
    }

    @Operation(summary = "Eliminar categoría", description = "Elimina una categoría del sistema por su ID.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
    }
}