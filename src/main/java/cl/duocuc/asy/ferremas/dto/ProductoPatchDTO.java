package cl.duocuc.asy.ferremas.dto;

import lombok.Data;

@Data
public class ProductoPatchDTO {
    private String nombre;
    private String descripcion;
    private String marca;
    private Integer stock;
    private String imagenUrl;
    private Boolean oferta;
    private Boolean nuevo;
    private Boolean activo;
    private Long categoriaId;
    private Long subCategoriaId;
    private Double precio;
}
