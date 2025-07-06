package cl.duocuc.asy.ferremas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    @Column(unique = true, nullable = false)
    private String rut;
    @Column(unique = true, nullable = false)
    private String correo;
    private String password;

    @Enumerated(EnumType.STRING)
    private RolEmpleado rol;

    @OneToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;
}
