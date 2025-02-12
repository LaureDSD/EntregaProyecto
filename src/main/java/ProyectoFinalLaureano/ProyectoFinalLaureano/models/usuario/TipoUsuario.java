package ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tipo_usuario")
@Schema(description = "Entidad que representa un tipo de usuario en el sistema")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de usuario", example = "1")
    private Long tipo_usuario_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del tipo de usuario", example = "usuario")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del tipo de usuario", example = "Acceso básico al juego")
    private String descripcion;

    // Relación Uno a Muchos con Usuario
    @OneToMany(mappedBy = "tipo_usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Usuario> usuarios;

}
