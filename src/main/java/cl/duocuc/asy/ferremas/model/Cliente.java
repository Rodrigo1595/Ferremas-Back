package cl.duocuc.asy.ferremas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidoPat;
    private String apellidoMat; 

    @Column(unique = true)
    private String rut;
    @Column(unique = true , nullable = false)
    private String correo;
    @Column(nullable = false)
    private String password;
    @Column(unique = true)

    private String telefono;
    private String direccion;
    private String ciudad;
    private String pais;
    private String codigoPostal;


    // Otros campos y métodos según sea necesario
}
