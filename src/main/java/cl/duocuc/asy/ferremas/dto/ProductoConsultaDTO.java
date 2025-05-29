package cl.duocuc.asy.ferremas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoConsultaDTO {
    private String codigoDelProducto; // "FER-12345"
    private String marca; // "Bosch"
    private String codigo; // "BOS-67890"
    private String nombre; // "Taladro Percutor Bosch"
    private List<PrecioDTO> precio; // Lista de precios
}
