package cl.duocuc.asy.ferremas.repository;

import cl.duocuc.asy.ferremas.model.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long> {
    // Métodos personalizados si es necesario
}