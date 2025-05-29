package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.Pedido;
import cl.duocuc.asy.ferremas.repository.PedidoRepository;

import org.springframework.stereotype.Service;

import cl.duocuc.asy.ferremas.services.service.PedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        if (pedido == null || pedido.getId() == null) {
            throw new IllegalArgumentException("El pedido o su ID no pueden ser nulos");
        }
        if (!pedidoRepository.existsById(pedido.getId())) {
            throw new IllegalArgumentException("El pedido con el ID especificado no existe");
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del pedido no puede ser nulo");
        }
        if (!pedidoRepository.existsById(id)) {
            throw new IllegalArgumentException("El pedido con el ID especificado no existe");
        }
        pedidoRepository.deleteById(id);
    }

    @Override
    public Iterable<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findByUsuarioId(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Pedido findBySucursalId(Long sucursalId) {
        return pedidoRepository.findBySucursalId(sucursalId);
    }

}
