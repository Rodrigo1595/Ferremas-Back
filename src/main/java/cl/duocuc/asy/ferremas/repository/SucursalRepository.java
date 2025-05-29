package cl.duocuc.asy.ferremas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duocuc.asy.ferremas.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
