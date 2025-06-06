package cl.duocuc.asy.ferremas.dto;

import lombok.Data;

@Data
public class ProductoResponseDTO {
    private Long id;
    private String codProducto;
    private String nombre;
    private String descripcion;
    private String marca;
    private Integer stock;
    private String imagenUrl;
    private Long categoriaId;
    private Long subCategoriaId;
    private Double precioActual;
    private Boolean oferta;
    private Boolean nuevo;
}
