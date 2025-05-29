package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Precio;
import cl.duocuc.asy.ferremas.services.service.PrecioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/precios")
@RequiredArgsConstructor
public class PrecioController {

    private final PrecioService precioService;

    @GetMapping("/{id}")
    public Precio getById(@PathVariable Long id) {
        return precioService.findById(id);
    }

    @PostMapping
    public Precio create(@RequestBody Precio precio) {
        return precioService.crearPrecio(precio);
    }

    @PutMapping("/{id}")
    public Precio update(@PathVariable Long id, @RequestBody Precio precio) {
        precio.setId(id);
        return precioService.actualizarPrecio(precio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        precioService.eliminarPrecio(id);
    }
}