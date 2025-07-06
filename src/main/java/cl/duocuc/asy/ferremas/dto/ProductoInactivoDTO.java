package cl.duocuc.asy.ferremas.dto;

import lombok.Data;

@Data
public class ProductoInactivoDTO {
    private String codProducto;
    private String nombre;
    private boolean activo;
}
