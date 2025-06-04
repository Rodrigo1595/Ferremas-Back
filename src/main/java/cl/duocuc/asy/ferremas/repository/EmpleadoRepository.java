package cl.duocuc.asy.ferremas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duocuc.asy.ferremas.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findByCorreo(String correo);
   

}
