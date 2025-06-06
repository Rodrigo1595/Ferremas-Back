package cl.duocuc.asy.ferremas.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "consulta_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_rut", referencedColumnName = "rut")
    private Cliente cliente;
    
    private String mensaje;
    private LocalDateTime fecha;
    private String mensajeCliente;
    private String respuestaVendedor;

    // Relación con Empleado 
    @ManyToOne
    @JoinColumn(name = "correo", referencedColumnName = "correo")
    private Empleado empleado;

    private boolean resuelto;
}
