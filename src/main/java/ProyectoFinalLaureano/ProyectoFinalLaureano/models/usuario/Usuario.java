package ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


    @NoArgsConstructor
    @RequiredArgsConstructor
    @Getter
    @Setter
    @Entity(name = "usuarios")
    public class Usuario {

        @Schema(description = "Identificador de cada usuario.", example = "1")
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int usuario_id;
        //private Long usuario_id;

        @Schema(description = "Imagen de perfil del usuario", example = "juanPerro.jpg")
        @Size(max = 255, message = "Limite 255 caracteres")
        private String imagen_perfil;

        @Schema(description = "Nombre publico del usuario.", example = "juan")
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
        @Column(length = 100, nullable = false)
        private String nombre_usuario_pub;

        @Schema(description = "Nombre privado del usuario.", example = "#1juan")
        @NotBlank(message = "El nombre priavdo no puede estar vacío")
        @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
        @Column(length = 100, nullable = false)
        private String nombre_usuario_priv;

        @Schema(description = "Limite de persnajes por cuenta.", example = "20")
        @Column(columnDefinition = "DECIMAL(10, 2) DEFAULT 0")
        private int total;




        @Schema(description = "Nombre del tipo de usuario.", example = "usuario")
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
        @Column(length = 100, nullable = false)
        private String string;

        @Schema(description = "Descripcion del tipo de usuario", example = "Gestiona el area de..")
        @NotBlank(message = "Las descripciones no pueden estar vacías")
        @Size(message = "Los apellidos no pueden exceder los 100 caracteres")
        @Column(columnDefinition = "TEXT")
        private String text;
    }