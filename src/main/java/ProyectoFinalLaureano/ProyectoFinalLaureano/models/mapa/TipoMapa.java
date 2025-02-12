package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tipo_mapa")
@Schema(description = "Entidad que representa un tipo de mapa en el sistema")
public class TipoMapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de mapa", example = "1")
    private Long tipo_mapa_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del tipo de mapa", example = "mazmorra")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del tipo de mapa", example = "Un lugar peligroso lleno de enemigos y tesoros")
    private String descripcion;

}
