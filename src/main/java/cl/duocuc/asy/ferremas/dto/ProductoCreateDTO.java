package cl.duocuc.asy.ferremas.dto;

import lombok.Data;

@Data
public class ProductoCreateDTO {
    private String nombre;
    private String descripcion;
    private String marca;
    private Integer stock;
    private String imagenUrl;
    private Long categoriaId;
    private Long subCategoriaId;
    private Double precio;
    private Boolean oferta;
}