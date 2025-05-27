package cl.duocuc.asy.ferremas.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrecioDTO {
    private LocalDateTime fecha; // ISO 8601: 2023-05-10T03:00:00.000Z
    private double valor;
}
