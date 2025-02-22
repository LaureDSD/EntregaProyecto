package ProyectoFinalLaureano.ProyectoFinalLaureano.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configuración global para todas las rutas
        registry.addMapping("/**")
                // Permite todos los orígenes, o puedes restringirlo: .allowedOrigins("http://example.com")
                //.allowedOrigins("*")
                .allowedOrigins("http://localhost:8080")
                // Métodos HTTP permitidos
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // Permitir credenciales, encabezados, etc.
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
