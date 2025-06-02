package cl.duocuc.asy.ferremas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duocuc.asy.ferremas.model.Precio;

import java.util.List;
import java.util.Optional;

public interface PrecioRepository extends JpaRepository<Precio, Long> {
    List<Precio> findByProductoId(Long productoId);
    Optional<Precio> findByProductoIdAndActivoTrue(Long productoId);
}
