package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.dto.LoginRequest;
import cl.duocuc.asy.ferremas.dto.EmpleadoLoginResponse;
import cl.duocuc.asy.ferremas.model.Empleado;
import cl.duocuc.asy.ferremas.services.service.EmpleadoService;
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

    @GetMapping("/{id}")
    public Empleado getById(@PathVariable Long id) {
        return usuarioService.obtenerEmpleadoPorId(id);
    }

    @PostMapping
    public Empleado create(@RequestBody Empleado usuario) {
        return usuarioService.crearEmpleado(usuario);
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