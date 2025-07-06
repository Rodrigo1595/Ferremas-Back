package cl.duocuc.asy.ferremas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.duocuc.asy.ferremas.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findBySubCategoriaId(Long subCategoriaId);

    List<Producto> findByCategoriaId(Long categoriaId);

    Optional<Producto> findByCodProducto(String codProducto);

    @Query("SELECT p.codProducto FROM Producto p ORDER BY p.codProducto DESC LIMIT 1")
    String obtenerUltimoCodigo();
}
