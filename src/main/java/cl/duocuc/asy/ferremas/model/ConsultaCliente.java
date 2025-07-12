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

    // Relación opcional con Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_rut", referencedColumnName = "rut", nullable = true)
    private Cliente cliente;
    
    // Agregar campo para correo directo en caso de consultas anónimas
    private String correoConsulta;
    
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
