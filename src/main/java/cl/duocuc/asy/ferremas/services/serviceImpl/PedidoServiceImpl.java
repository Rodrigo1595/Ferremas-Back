package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.Pedido;
import cl.duocuc.asy.ferremas.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import cl.duocuc.asy.ferremas.services.service.PedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
@Transactional
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido findById(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del pedido no puede ser nulo");
        }
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado"));
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        if (pedido == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El pedido no puede ser nulo");
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        if (pedido == null || pedido.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El pedido o su ID no pueden ser nulos");
        }
        if (!pedidoRepository.existsById(pedido.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El pedido con el ID especificado no existe");
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del pedido no puede ser nulo");
        }
        if (!pedidoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El pedido con el ID especificado no existe");
        }
        pedidoRepository.deleteById(id);
    }

    @Override
    public Iterable<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findByUsuarioId(Long usuarioId) {
        if (usuarioId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del usuario no puede ser nulo");
        }
        Pedido pedido = pedidoRepository.findByUsuarioId(usuarioId);
        if (pedido == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado para el usuario dado");
        }
        return pedido;
    }

    @Override
    public Pedido findBySucursalId(Long sucursalId) {
        if (sucursalId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID de la sucursal no puede ser nulo");
        }
        Pedido pedido = pedidoRepository.findBySucursalId(sucursalId);
        if (pedido == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado para la sucursal dada");
        }
        return pedido;
    }
}
