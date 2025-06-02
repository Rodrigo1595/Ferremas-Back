package cl.duocuc.asy.ferremas.repository;

import cl.duocuc.asy.ferremas.model.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long> {
    List<SubCategoria> findByCategoriaId(Long categoriaId);
}