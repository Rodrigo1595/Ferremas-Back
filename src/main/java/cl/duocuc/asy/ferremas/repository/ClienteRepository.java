package cl.duocuc.asy.ferremas.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duocuc.asy.ferremas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCorreo(String correo);
    Optional<Cliente> findByRut(String rut);
}
