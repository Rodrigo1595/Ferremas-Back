package cl.duocuc.asy.ferremas.dto;

import java.util.List;
import lombok.Data;

@Data
public class PedidoCreateDTO {
    private Long clienteId;
    private List<ItemPedidoDTO> items;

    @Data
    public static class ItemPedidoDTO {
        private String codProducto;
        private int cantidad;
    }
}
