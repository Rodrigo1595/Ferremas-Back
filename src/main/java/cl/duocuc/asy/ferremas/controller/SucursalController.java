package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Sucursal;
import cl.duocuc.asy.ferremas.services.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sucursales")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @GetMapping
    public Iterable<Sucursal> getAll() {
        return sucursalService.findAll();
    }

    @GetMapping("/{id}")
    public Sucursal getById(@PathVariable Long id) {
        return sucursalService.buscarPorId(id);
    }

    @PostMapping
    public Sucursal create(@RequestBody Sucursal sucursal) {
        return sucursalService.crearSucursal(sucursal);
    }

    @PutMapping("/{id}")
    public Sucursal update(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        sucursal.setId(id);
        return sucursalService.actualizarSucursal(sucursal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
    }
}