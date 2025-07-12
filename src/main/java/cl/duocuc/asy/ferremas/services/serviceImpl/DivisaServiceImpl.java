package cl.duocuc.asy.ferremas.services.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import cl.duocuc.asy.ferremas.services.service.DivisaService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.List;

@Service
public class DivisaServiceImpl implements DivisaService {

    @Value("${BCENTRAL_USER:default_user}")
    private String user;

    @Value("${BCENTRAL_PASS:default_pass}")
    private String pass;

    @Value("${BCENTRAL_URL:https://si3.bcentral.cl}")
    private String baseUrl;

    private final WebClient webClient;

    public DivisaServiceImpl(@Value("${BCENTRAL_URL:https://si3.bcentral.cl}") String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public Map obtenerValorDolar() {
        // Usar valores directos para trabajo académico
        LocalDate today = LocalDate.now();
        String fecha = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        try {
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/SieteRestWS/SieteRestWS.ashx")
                            .queryParam("user", "amigo.rodrigo.morgado@gmail.com")
                            .queryParam("pass", "BcoCentralBdeRod07#!")
                            .queryParam("timeseries", "F073.TCO.PRE.Z.D")
                            .queryParam("firstdate", fecha)
                            .queryParam("lastdate", fecha)
                            .build())
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        } catch (Exception e) {
            // Si falla la consulta real, retornar datos simulados
            return Map.of(
                "Codigo", 0,
                "Descripcion", "Datos simulados - Servicio no disponible",
                "Series", Map.of(
                    "Obs", List.of(Map.of(
                        "indexDateString", LocalDate.now().toString(),
                        "value", 950.0
                    ))
                )
            );
        }
    }
}
