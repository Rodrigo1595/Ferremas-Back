package cl.duocuc.asy.ferremas.services.serviceImpl;

import org.springframework.stereotype.Service;
import cl.duocuc.asy.ferremas.model.ItemPedido;
import cl.duocuc.asy.ferremas.repository.ItemPedidoRepository;
import cl.duocuc.asy.ferremas.services.service.ItemPedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemPedidoServiceImpl implements ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    public ItemPedido crearItemPedido(ItemPedido itemPedido) {
        if (itemPedido == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El item de pedido no puede ser nulo");
        }
        return itemPedidoRepository.save(itemPedido);
    }

    @Override
    public ItemPedido actualizarItemPedido(ItemPedido itemPedido) {
        if (itemPedido == null || itemPedido.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El item de pedido o su ID no pueden ser nulos");
        }
        if (!itemPedidoRepository.existsById(itemPedido.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El item de pedido con el ID especificado no existe");
        }
        return itemPedidoRepository.save(itemPedido);
    }

    @Override
    public void eliminarItemPedido(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del item de pedido no puede ser nulo");
        }
        if (!itemPedidoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El item de pedido con el ID especificado no existe");
        }
        itemPedidoRepository.deleteById(id);
    }

    @Override
    public ItemPedido findByPedidoId(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del pedido no puede ser nulo");
        }
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item de pedido no encontrado para el pedido dado"));
    }

    @Override
    public ItemPedido findByProductoId(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del producto no puede ser nulo");
        }
        ItemPedido item = itemPedidoRepository.findByProductoId(id).orElse(null);
        if (item == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item de pedido no encontrado para el producto dado");
        }
        return item;
    }

    @Override
    public ItemPedido findById(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del item de pedido no puede ser nulo");
        }
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item de pedido no encontrado"));
    }

    @Override
    public Iterable<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }
}
