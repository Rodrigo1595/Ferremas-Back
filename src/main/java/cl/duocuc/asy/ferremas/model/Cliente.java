package cl.duocuc.asy.ferremas.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Cliente")
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
    private String fechaNacimiento;

    @Column(unique = true)
    private String rut;
    @Column(unique = true, nullable = false)
    private String correo;
    @Column(nullable = false)
    private String password;
    @Column(unique = true)
    private String telefono;

    private String direccion;
    private String ciudad;
    private String pais;
    private String codigoPostal;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private List<Pedido> pedidos;

    // Otros campos y métodos según sea necesario
}
