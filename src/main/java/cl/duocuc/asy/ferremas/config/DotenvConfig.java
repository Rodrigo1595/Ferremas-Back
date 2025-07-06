package cl.duocuc.asy.ferremas.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class DotenvConfig {

    @PostConstruct
    public void loadEnvVariables() {
        try {
            Dotenv dotenv = Dotenv.configure()
                .directory(".")
                .ignoreIfMissing()
                .load();
            
            // Cargar variables al System Properties para que Spring las pueda leer
            dotenv.entries().forEach(entry -> {
                if (System.getProperty(entry.getKey()) == null) {
                    System.setProperty(entry.getKey(), entry.getValue());
                }
            });
        } catch (Exception e) {
            // En producción las variables vendrán del sistema operativo
            System.out.println("No se encontró archivo .env, usando variables de entorno del sistema");
        }
    }
}
