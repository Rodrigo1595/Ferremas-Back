package cl.duocuc.asy.ferremas.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsultaClienteResponseDTO {
    private Long id;
    private String clienteRut;
    private String mensaje;
    private LocalDateTime fecha;
    private String mensajeCliente;
    private String respuestaVendedor;
    private String correo;
    private boolean resuelto;
}
