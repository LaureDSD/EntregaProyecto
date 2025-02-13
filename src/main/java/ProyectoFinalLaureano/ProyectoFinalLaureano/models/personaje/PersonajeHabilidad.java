package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "personaje_habilidad")
@Schema(description = "Entidad que representa la relación entre un personaje y las habilidades que posee")
@Getter
@Setter
public class PersonajeHabilidad {

    @EmbeddedId
    private PersonajeHabilidadId id;

    @Column(name = "nivel", nullable = false, columnDefinition = "INT DEFAULT 1")
    @Schema(description = "Nivel de la habilidad del personaje", example = "1")
    private Integer nivel;

    @Column(name = "ultimo_uso")
    @Schema(description = "Última fecha y hora de uso de la habilidad", example = "2025-02-13T14:00:00")
    private LocalDateTime ultimoUso;

    // Relación con la tabla personaje
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaje_id", insertable = false, updatable = false)
    private Personaje personajeRelacionado;

    // Relación con la tabla habilidad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habilidad_id", insertable = false, updatable = false)
    private Habilidad habilidadRelacionado;
}
