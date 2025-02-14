package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.EstadoMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "personaje_mision")
@Schema(description = "Entidad que representa la relación entre un personaje y una misión")
@Getter
@Setter
public class PersonajeMision {

    @EmbeddedId
    private PersonajeMisionId id;

    @ManyToOne
    @MapsId("personaje_id")
    @JoinColumn(name = "personaje_id", nullable = false)
    @Schema(description = "Personaje asociado a la misión")
    private Personaje personaje;

    @ManyToOne
    @MapsId("mision_id")
    @JoinColumn(name = "mision_id", nullable = false)
    @Schema(description = "Misión asociada al personaje")
    private Mision mision;

    @Column(name = "fecha_inicio", nullable = false)
    @Schema(description = "Fecha y hora de inicio de la misión", example = "2023-10-01T12:00:00")
    private LocalDateTime fecha_inicio;

    @Column(name = "fecha_fin")
    @Schema(description = "Fecha y hora de finalización de la misión", example = "2023-10-02T12:00:00")
    private LocalDateTime fecha_fin;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    @Schema(description = "Estado de la misión (en_progreso, completada, fallida)", example = "en_progreso")
    private EstadoMision estado;
}

