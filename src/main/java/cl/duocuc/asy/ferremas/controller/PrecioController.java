package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Precio;
import cl.duocuc.asy.ferremas.services.service.PrecioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Precios", description = "Gestión de precios: registrar, actualizar, eliminar y consultar precios históricos de productos.")
@RestController
@RequestMapping("/api/precios")
@RequiredArgsConstructor
public class PrecioController {

    private final PrecioService precioService;

    @GetMapping("/{id}")
    public Precio getById(@PathVariable Long id) {
        return precioService.findById(id);
    }

    // @PostMapping
    // public Precio create(@RequestBody Precio precio) {
    //     return precioService.crearPrecio(precio);
    // }

    @PutMapping("/{id}")
    public Precio update(@PathVariable Long id, @RequestBody Precio precio) {
        precio.setId(id);
        return precioService.actualizarPrecio(precio);
    }

    // @DeleteMapping("/{id}")
    // public void delete(@PathVariable Long id) {
    //     precioService.eliminarPrecio(id);
    // }
}