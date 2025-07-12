package cl.duocuc.asy.ferremas.dto;

import lombok.Data;

@Data
public class ItemPedidoResponseDTO {
    private Long id;
    private int cantidad;
    private ProductoResponseDTO producto;
    private Long pedidoId;
}
