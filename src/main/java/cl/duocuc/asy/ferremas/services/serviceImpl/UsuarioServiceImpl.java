package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.Usuario;
import cl.duocuc.asy.ferremas.repository.UsuarioRepository;
import cl.duocuc.asy.ferremas.services.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getId() == null) {
            throw new IllegalArgumentException("El usuario o su ID no pueden ser nulos");
        }
        if (!usuarioRepository.existsById(usuario.getId())) {
            throw new IllegalArgumentException("El usuario con el ID especificado no existe");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo");
        }
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("El usuario con el ID especificado no existe");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo");
        }
        return usuarioRepository.findById(id).orElse(null);
    }

}
