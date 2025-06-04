package cl.duocuc.asy.ferremas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @ToString.Exclude
    @JsonIgnore
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @ToString.Exclude
    @JsonIgnore
    private Pedido pedido;
}
