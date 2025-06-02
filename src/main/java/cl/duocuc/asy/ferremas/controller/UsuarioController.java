package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Usuario;
import cl.duocuc.asy.ferremas.services.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Usuarios", description = "Gestión de usuarios: crear, actualizar, eliminar y consultar usuarios por ID o correo.")
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/correo/{correo}")
    public Usuario getByCorreo(@PathVariable String correo) {
        return usuarioService.obtenerUsuarioPorEmail(correo);
    }
}