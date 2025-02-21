package ProyectoFinalLaureano.ProyectoFinalLaureano.config;

// Esta clase se encargará de servir las imágenes estáticas de nuestro proyecto

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Se resuelve la ruta absoluta de la carpeta relativa (user.dir + upload.path)
        String absolutePath = Paths.get(System.getProperty("user.dir"), uploadPath)
                .toAbsolutePath()
                .toUri()
                .toString();

        // Mapeamos la URL /uploads/** a la carpeta de imágenes
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(absolutePath);
    }
}
