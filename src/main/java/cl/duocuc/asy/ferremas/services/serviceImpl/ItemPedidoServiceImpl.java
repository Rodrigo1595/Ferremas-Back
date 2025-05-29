package cl.duocuc.asy.ferremas.services.serviceImpl;

import org.springframework.stereotype.Service;
import cl.duocuc.asy.ferremas.model.ItemPedido;
import cl.duocuc.asy.ferremas.repository.ItemPedidoRepository;

import cl.duocuc.asy.ferremas.services.service.ItemPedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemPedidoServiceImpl implements ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    public ItemPedido crearItemPedido(ItemPedido itemPedido) {
        if (itemPedido == null) {
            throw new IllegalArgumentException("El item de pedido no puede ser nulo");
        }
        return itemPedidoRepository.save(itemPedido);
    }

    @Override
    public ItemPedido actualizarItemPedido(ItemPedido itemPedido) {
        if (itemPedido == null || itemPedido.getId() == null) {
            throw new IllegalArgumentException("El item de pedido o su ID no pueden ser nulos");
        }
        if (!itemPedidoRepository.existsById(itemPedido.getId())) {
            throw new IllegalArgumentException("El item de pedido con el ID especificado no existe");
        }
        return itemPedidoRepository.save(itemPedido);
    }

    @Override
    public void eliminarItemPedido(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del item de pedido no puede ser nulo");
        }
        if (!itemPedidoRepository.existsById(id)) {
            throw new IllegalArgumentException("El item de pedido con el ID especificado no existe");
        }
        itemPedidoRepository.deleteById(id);
    }

    @Override
    public ItemPedido findByPedidoId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del item de pedido no puede ser nulo");
        }
        return itemPedidoRepository.findById(id).orElse(null);
    }

    @Override
    public ItemPedido findByProductoId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del producto no puede ser nulo");
        }
        return itemPedidoRepository.findByProductoId(id).orElse(null);
    }

    @Override
    public ItemPedido findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del item de pedido no puede ser nulo");
        }
        return itemPedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }

}
