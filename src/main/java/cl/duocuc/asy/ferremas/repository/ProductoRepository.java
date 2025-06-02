package cl.duocuc.asy.ferremas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duocuc.asy.ferremas.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoriaId(Long categoriaId);

    Optional<Producto> findByCodProducto(String codProducto);
}
