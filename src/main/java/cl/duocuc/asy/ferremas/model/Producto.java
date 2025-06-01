package cl.duocuc.asy.ferremas.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^FER-\\d{6}$", message = "El código debe tener el formato FER-999999")
    @Column(name = "codProducto", nullable = false, unique = true)
    private String codProducto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @OneToMany(mappedBy = "producto", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private List<Precio> precios;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

}
