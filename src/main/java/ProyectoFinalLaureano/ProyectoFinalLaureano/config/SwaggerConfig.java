package ProyectoFinalLaureano.ProyectoFinalLaureano.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://localhost:8080/swagger-ui.html

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API_RPG_DOCUMENTACION")
                        .version("1.0")
                        .description("Documentacion")
                        .contact(new Contact()
                                .name("Documentacion de puntos de acceso a la API")
                                .email("laureano.de.sousa@iessanmamede.com")
                                .url("url")));
    }
}
