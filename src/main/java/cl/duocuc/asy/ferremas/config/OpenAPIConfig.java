package cl.duocuc.asy.ferremas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Ferremas API")
                .version("1.0")
                .description("""
                    <b>Ferremas API</b> es una plataforma RESTful para la gestión integral de una ferretería.<br>
                    <br>
                    <b>Características principales:</b>
                    <ul>
                      <li>Gestión de productos, categorías y subcategorías.</li>
                      <li>Histórico de precios y control de precio activo.</li>
                      <li>Gestión de usuarios, sucursales y pedidos.</li>
                      <li>Integración con Transbank Webpay Plus (modo pruebas).</li>
                      <li>Consulta de valor del dólar en tiempo real vía Banco Central de Chile.</li>
                      <li>Documentación interactiva con Swagger/OpenAPI.</li>
                    </ul>
                    <b>Endpoints destacados:</b>
                    <ul>
                      <li><code>/api/productos</code>: CRUD de productos y consulta de precios.</li>
                      <li><code>/api/categorias</code>, <code>/api/subcategorias</code>: Gestión de categorías.</li>
                      <li><code>/api/precios</code>: Histórico y gestión de precios.</li>
                      <li><code>/api/usuarios</code>: Gestión de usuarios.</li>
                      <li><code>/api/sucursales</code>: Gestión de sucursales.</li>
                      <li><code>/api/pedidos</code>: Gestión de pedidos.</li>
                      <li><code>/api/webpay</code>: Integración de pagos electrónicos.</li>
                      <li><code>/api/divisas/dolar</code>: Valor del dólar en tiempo real.</li>
                    </ul>
                    <br>
                    <b>Raccoon dev a cargo 🦝 : </b> <a href="https://github.com/Rodrigo1595" target="_blank">Rodrigo1595</a>
                    """));
    }
}