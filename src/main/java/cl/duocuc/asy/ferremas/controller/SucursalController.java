package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Sucursal;
import cl.duocuc.asy.ferremas.services.service.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Sucursales", description = "Gestión de sucursales: crear, actualizar, eliminar y consultar sucursales.")
@RestController
@RequestMapping("/api/sucursales")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @Operation(summary = "Listar todas las sucursales", description = "Obtiene el listado completo de todas las sucursales registradas.")
    @GetMapping
    public Iterable<Sucursal> getAll() {
        return sucursalService.findAll();
    }

    @Operation(summary = "Obtener sucursal por ID", description = "Devuelve los detalles de una sucursal específica según su identificador único.")
    @GetMapping("/{id}")
    public Sucursal getById(@PathVariable Long id) {
        return sucursalService.buscarPorId(id);
    }

    @Operation(summary = "Crear una nueva sucursal", description = "Registra una nueva sucursal en el sistema.")
    @PostMapping
    public Sucursal create(@RequestBody Sucursal sucursal) {
        return sucursalService.crearSucursal(sucursal);
    }

    @Operation(summary = "Actualizar sucursal", description = "Actualiza los datos de una sucursal existente por su ID.")
    @PutMapping("/{id}")
    public Sucursal update(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        sucursal.setId(id);
        return sucursalService.actualizarSucursal(sucursal);
    }

    @Operation(summary = "Eliminar sucursal", description = "Elimina una sucursal del sistema por su ID.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
    }
}