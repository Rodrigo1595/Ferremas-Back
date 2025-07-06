package cl.duocuc.asy.ferremas.services.scheduler;

import cl.duocuc.asy.ferremas.model.Producto;
import cl.duocuc.asy.ferremas.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductoNuevoScheduler {

    private final ProductoRepository productoRepository;

    // Ejecuta todos los días a las 00:00
    @Scheduled(cron = "0 0 0 * * *")
    public void actualizarProductosNuevos() {
        LocalDate hoy = LocalDate.now();
        List<Producto> productos = productoRepository.findAll();
        for (Producto producto : productos) {
            if (producto.isNuevo() && producto.getFechaIngreso() != null) {
                LocalDate fechaIngreso = producto.getFechaIngreso().toLocalDate();
                if (fechaIngreso.plusDays(30).isBefore(hoy) || fechaIngreso.plusDays(30).isEqual(hoy)) {
                    producto.setNuevo(false);
                    productoRepository.save(producto);
                }
            }
        }
    }
}
