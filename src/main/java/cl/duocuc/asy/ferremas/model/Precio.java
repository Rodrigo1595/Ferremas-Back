package cl.duocuc.asy.ferremas.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "precio")
public class Precio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @ToString.Exclude
    private Producto producto;
}
