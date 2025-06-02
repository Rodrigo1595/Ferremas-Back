package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.services.service.DivisaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@Tag(name = "Divisas", description = "Consulta de valor del dólar en tiempo real usando el Banco Central de Chile.")
@RestController
@RequestMapping("/api/divisas")
@RequiredArgsConstructor
public class DivisaController {

    private final DivisaService divisaService;

    @GetMapping("/dolar")
    public Map obtenerValorDolar() {
        return divisaService.obtenerValorDolar();
    }
}
