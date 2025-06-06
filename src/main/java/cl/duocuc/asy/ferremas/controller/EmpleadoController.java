package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.dto.LoginRequest;
import cl.duocuc.asy.ferremas.dto.EmpleadoLoginResponse;
import cl.duocuc.asy.ferremas.dto.EmpleadoCreateDTO;
import cl.duocuc.asy.ferremas.model.Empleado;
import cl.duocuc.asy.ferremas.model.Sucursal;
import cl.duocuc.asy.ferremas.services.service.EmpleadoService;
import cl.duocuc.asy.ferremas.services.service.SucursalService;
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

    @GetMapping("/{id}")
    public Empleado getById(@PathVariable Long id) {
        return usuarioService.obtenerEmpleadoPorId(id);
    }

    @PostMapping
    public Empleado create(@RequestBody EmpleadoCreateDTO dto) {
        Sucursal sucursal = null;
        if (dto.getSucursal() != null && dto.getSucursal().getId() != null) {
            // Debes tener un SucursalService para buscar la sucursal por ID
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

    @PutMapping("/{id}")
    public Empleado update(@PathVariable Long id, @RequestBody Empleado usuario) {
        usuario.setId(id);
        return usuarioService.actualizarEmpleado(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.eliminarEmpleado(id);
    }

    @GetMapping("/correo/{correo}")
    public Empleado getByCorreo(@PathVariable String correo) {
        return usuarioService.obtenerEmpleadoPorEmail(correo);
    }

    @PostMapping("/login")
    public EmpleadoLoginResponse login(@RequestBody LoginRequest loginRequest) {
        return usuarioService.login(loginRequest.getCorreo(), loginRequest.getPassword());
    }
}