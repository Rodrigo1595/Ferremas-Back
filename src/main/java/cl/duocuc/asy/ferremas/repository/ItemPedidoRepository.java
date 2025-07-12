package cl.duocuc.asy.ferremas.repository;

import cl.duocuc.asy.ferremas.model.ItemPedido;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    Optional<ItemPedido> findByProductoId(Long id);
    
    // Agregar método para encontrar todos los ítems de un pedido
    List<ItemPedido> findByPedidoId(Long pedidoId);
}
