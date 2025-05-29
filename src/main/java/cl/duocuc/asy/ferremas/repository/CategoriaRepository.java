package cl.duocuc.asy.ferremas.repository;

import cl.duocuc.asy.ferremas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Puedes agregar métodos personalizados si es necesario
}