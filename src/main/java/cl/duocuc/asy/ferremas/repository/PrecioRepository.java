package cl.duocuc.asy.ferremas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duocuc.asy.ferremas.model.Precio;

public interface PrecioRepository extends JpaRepository<Precio, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
