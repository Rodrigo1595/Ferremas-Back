package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.services.service.DivisaService;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

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
