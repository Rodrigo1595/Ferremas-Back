package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.Usuario;

public interface UsuarioService {
    Usuario obtenerUsuarioPorId(Long id);

    Usuario crearUsuario(Usuario usuario);

    Usuario actualizarUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

    Usuario obtenerUsuarioPorEmail(String email);

}
