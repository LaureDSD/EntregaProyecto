package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.enums.EstadoMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "personaje_mision")
@Schema(description = "Entidad que representa la relación entre un personaje y una misión")
@Getter
@Setter
public class PersonajeMision {

    //ID de la relacion
    @EmbeddedId
    private PersonajeMisionId id;

    //Persoanje relacionado N:1
    @ManyToOne
    @MapsId("personaje_id")
    @JoinColumn(name = "personaje_id", nullable = false)
    @Schema(description = "Personaje asociado a la misión")
    private Personaje personaje;

    //Mision relacionada N:1
    @ManyToOne
    @MapsId("mision_id")
    @JoinColumn(name = "mision_id", nullable = false)
    @Schema(description = "Misión asociada al personaje")
    private Mision mision;

    //Fecha en la que se recive la mision
    @Column(name = "fecha_inicio", nullable = false)
    @Schema(description = "Fecha y hora de inicio de la misión", example = "2023-10-01T12:00:00")
    private LocalDateTime fecha_inicio;

    //Fecha en la que se termina
    @Column(name = "fecha_fin")
    @Schema(description = "Fecha y hora de finalización de la misión", example = "2023-10-02T12:00:00")
    private LocalDateTime fecha_fin;

    //Estado de la mision
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    @Schema(description = "Estado de la misión (en_progreso, completada, fallida)", example = "en_progreso")
    private EstadoMision estado;
}

