package cl.duocuc.asy.ferremas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duocuc.asy.ferremas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    // Aquí puedes agregar métodos personalizados si es necesario

}
