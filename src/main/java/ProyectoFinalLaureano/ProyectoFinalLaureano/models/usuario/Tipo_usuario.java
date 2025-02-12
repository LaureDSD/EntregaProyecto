package ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "tipo_usuario")
public class Tipo_usuario {
    @Schema(description = "Identificador de cada tipo.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipo_usuario_id;
    @Schema(description = "Nombre del tipo de usuario.", example = "usuario")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    @Column(length = 100, nullable = false)
    private String nombre;
    @Schema(description = "Descripcion del tipo de usuario", example = "Gestiona el area de..")
    @NotBlank(message = "Las descripciones no pueden estar vacías")
    @Size(message = "Los apellidos no pueden exceder los 100 caracteres")
    @Column(columnDefinition = "TEXT")
    private String descripcion;
}
