package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.SubCategoria;
import cl.duocuc.asy.ferremas.services.service.SubCategoriaService;
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

    @GetMapping
    public List<SubCategoria> getAll() {
        return subCategoriaService.findAll();
    }

    @GetMapping("/{id}")
    public SubCategoria getById(@PathVariable Long id) {
        return subCategoriaService.buscarPorId(id);
    }

    @PostMapping
    public SubCategoria create(@RequestBody SubCategoria subCategoria) {
        return subCategoriaService.crearSubCategoria(subCategoria);
    }

    @PutMapping("/{id}")
    public SubCategoria update(@PathVariable Long id, @RequestBody SubCategoria subCategoria) {
        subCategoria.setId(id);
        return subCategoriaService.actualizarSubCategoria(subCategoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subCategoriaService.eliminarSubCategoria(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<SubCategoria> getByCategoriaId(@PathVariable Long categoriaId) {
        return subCategoriaService.findByCategoriaId(categoriaId);
    }
}