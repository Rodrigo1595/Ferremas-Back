package cl.duocuc.asy.ferremas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duocuc.asy.ferremas.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Pedido findByUsuarioId(Long usuarioId);
    // Aquí puedes agregar métodos personalizados si es necesario

    Pedido findBySucursalId(Long sucursalId);

}
