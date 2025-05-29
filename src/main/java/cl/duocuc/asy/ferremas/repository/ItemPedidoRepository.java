package cl.duocuc.asy.ferremas.repository;

import cl.duocuc.asy.ferremas.model.ItemPedido;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    Optional<ItemPedido> findByProductoId(Long id);
    // Aquí puedes agregar métodos personalizados si es necesario

}
