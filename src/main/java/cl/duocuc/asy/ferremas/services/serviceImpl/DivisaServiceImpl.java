package cl.duocuc.asy.ferremas.services.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import cl.duocuc.asy.ferremas.services.service.DivisaService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class DivisaServiceImpl implements DivisaService {

    @Value("${bcentral.user}")
    private String user;

    @Value("${bcentral.pass}")
    private String pass;

    @Value("${bcentral.url}")
    private String baseUrl;

    private final WebClient webClient;

    public DivisaServiceImpl(@Value("${bcentral.url}") String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public Map obtenerValorDolar() {
        LocalDate today = LocalDate.now();
        String fecha = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/SieteRestWS/SieteRestWS.ashx")
                        .queryParam("user", user)
                        .queryParam("pass", pass)
                        .queryParam("timeseries", "F073.TCO.PRE.Z.D")
                        .queryParam("firstdate", fecha)
                        .queryParam("lastdate", fecha)
                        .build())
                .retrieve()
                .bodyToMono(Map.class)
                .block();

    }
}
