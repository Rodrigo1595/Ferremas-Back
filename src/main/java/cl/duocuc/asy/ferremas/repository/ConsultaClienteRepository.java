package cl.duocuc.asy.ferremas.repository;

import cl.duocuc.asy.ferremas.model.ConsultaCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaClienteRepository extends JpaRepository<ConsultaCliente, Long> {
    List<ConsultaCliente> findByResuelto(boolean resuelto);
    List<ConsultaCliente> findByClienteRut(String clienteRut);
    List<ConsultaCliente> findByCliente_Correo(String correo);
}
