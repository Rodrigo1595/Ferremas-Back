package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.SubCategoria;
import cl.duocuc.asy.ferremas.services.service.SubCategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Subcategorías", description = "Gestión de subcategorías: crear, listar, actualizar y eliminar subcategorías asociadas a categorías.")
@RestController
@RequestMapping("/api/subcategorias")
@RequiredArgsConstructor
public class SubCategoriaController {

    private final SubCategoriaService subCategoriaService;

    @Operation(summary = "Listar todas las subcategorías", description = "Obtiene el listado completo de todas las subcategorías registradas.")
    @GetMapping
    public List<SubCategoria> getAll() {
        return subCategoriaService.findAll();
    }

    @Operation(summary = "Obtener subcategoría por ID", description = "Devuelve los detalles de una subcategoría específica según su identificador único.")
    @GetMapping("/{id}")
    public SubCategoria getById(@PathVariable Long id) {
        return subCategoriaService.buscarPorId(id);
    }

    @Operation(summary = "Crear una nueva subcategoría", description = "Registra una nueva subcategoría en el sistema.")
    @PostMapping
    public SubCategoria create(@RequestBody SubCategoria subCategoria) {
        return subCategoriaService.crearSubCategoria(subCategoria);
    }

    @Operation(summary = "Actualizar subcategoría", description = "Actualiza los datos de una subcategoría existente por su ID.")
    @PutMapping("/{id}")
    public SubCategoria update(@PathVariable Long id, @RequestBody SubCategoria subCategoria) {
        subCategoria.setId(id);
        return subCategoriaService.actualizarSubCategoria(subCategoria);
    }

    @Operation(summary = "Eliminar subcategoría", description = "Elimina una subcategoría del sistema por su ID.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subCategoriaService.eliminarSubCategoria(id);
    }

    @Operation(summary = "Listar subcategorías por categoría", description = "Obtiene todas las subcategorías asociadas a una categoría específica por su ID.")
    @GetMapping("/categoria/{categoriaId}")
    public List<SubCategoria> getByCategoriaId(@PathVariable Long categoriaId) {
        return subCategoriaService.findByCategoriaId(categoriaId);
    }
}