package cl.duocuc.asy.ferremas.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsultaClienteCreateDTO {
    private String clienteRut;
    private String mensaje;
    private LocalDateTime fecha;
    private String mensajeCliente;
}
