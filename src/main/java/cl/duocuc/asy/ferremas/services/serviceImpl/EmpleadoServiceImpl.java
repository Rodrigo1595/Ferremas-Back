package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.dto.EmpleadoLoginResponse;
import cl.duocuc.asy.ferremas.model.Empleado;
import cl.duocuc.asy.ferremas.repository.EmpleadoRepository;
import cl.duocuc.asy.ferremas.services.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Empleado crearEmpleado(Empleado usuario) {
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario no puede ser nulo");
        }
        // Hashear la contraseña antes de guardar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado usuario) {
        if (usuario == null || usuario.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario o su ID no pueden ser nulos");
        }
        if (!usuarioRepository.existsById(usuario.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario con el ID especificado no existe");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del usuario no puede ser nulo");
        }
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario con el ID especificado no existe");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public Empleado obtenerEmpleadoPorEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El email no puede ser nulo o vacío");
        }
        return usuarioRepository.findByCorreo(email).orElse(null);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del usuario no puede ser nulo");
        }
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public EmpleadoLoginResponse login(String correo, String password) {
        if (correo == null || password == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Correo y contraseña son requeridos");
        }
        Empleado empleado = usuarioRepository.findByCorreo(correo)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas"));
        // Comparar la contraseña en texto plano con el hash
        if (!passwordEncoder.matches(password, empleado.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }
        EmpleadoLoginResponse response = new EmpleadoLoginResponse();
        response.setCorreo(empleado.getCorreo());
        response.setRol(empleado.getRol());
        return response;
    }
}
