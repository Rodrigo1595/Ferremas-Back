package cl.duocuc.asy.ferremas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duocuc.asy.ferremas.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long usuarioId);

    Pedido findBySucursalId(Long sucursalId);

    Pedido findByCorreoCliente(String correoCliente);

    List<Pedido> findByClienteCorreoPedido(String correo);

}
