package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.dto.LoginRequest;
import cl.duocuc.asy.ferremas.dto.EmpleadoLoginResponse;
import cl.duocuc.asy.ferremas.dto.EmpleadoCreateDTO;
import cl.duocuc.asy.ferremas.model.Empleado;
import cl.duocuc.asy.ferremas.model.Sucursal;
import cl.duocuc.asy.ferremas.services.service.EmpleadoService;
import cl.duocuc.asy.ferremas.services.service.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Empleados", description = 
"Gestión de Empleados: crear, actualizar, eliminar y consultar usuarios por ID o correo.")
@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService usuarioService;
    private final SucursalService sucursalService;

    @Operation(summary = "Obtener empleado por ID", description = "Devuelve los detalles de un empleado específico según su identificador único.")
    @GetMapping("/{id}")
    public Empleado getById(@PathVariable Long id) {
        return usuarioService.obtenerEmpleadoPorId(id);
    }

    @Operation(summary = "Crear un nuevo empleado", description = "Registra un nuevo empleado en el sistema.")
    @PostMapping
    public Empleado create(@RequestBody EmpleadoCreateDTO dto) {
        Sucursal sucursal = null;
        if (dto.getSucursal() != null && dto.getSucursal().getId() != null) {
            sucursal = sucursalService.buscarPorId(dto.getSucursal().getId());
        }
        Empleado empleado = new Empleado();
        empleado.setNombreCompleto(dto.getNombreCompleto());
        empleado.setRut(dto.getRut());
        empleado.setCorreo(dto.getCorreo());
        empleado.setPassword(dto.getPassword());
        empleado.setRol(dto.getRol());
        empleado.setSucursal(sucursal);
        return usuarioService.crearEmpleado(empleado);
    }

    @Operation(summary = "Actualizar empleado", description = "Actualiza los datos de un empleado existente por su ID.")
    @PutMapping("/{id}")
    public Empleado update(@PathVariable Long id, @RequestBody Empleado usuario) {
        usuario.setId(id);
        return usuarioService.actualizarEmpleado(usuario);
    }

    @Operation(summary = "Eliminar empleado", description = "Elimina un empleado del sistema por su ID.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.eliminarEmpleado(id);
    }

    @Operation(summary = "Obtener empleado por correo", description = "Devuelve los detalles de un empleado específico según su correo electrónico.")
    @GetMapping("/correo/{correo}")
    public Empleado getByCorreo(@PathVariable String correo) {
        return usuarioService.obtenerEmpleadoPorEmail(correo);
    }

    @Operation(summary = "Login de empleado", description = "Permite a un empleado autenticarse usando su correo y contraseña.")
    @PostMapping("/login")
    public EmpleadoLoginResponse login(@RequestBody LoginRequest loginRequest) {
        return usuarioService.login(loginRequest.getCorreo(), loginRequest.getPassword());
    }
}