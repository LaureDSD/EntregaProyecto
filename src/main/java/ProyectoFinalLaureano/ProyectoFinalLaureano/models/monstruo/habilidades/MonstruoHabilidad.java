package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "monstruo_habilidad")
@Schema(description = "Entidad que representa la relación entre los monstruos y las habilidades que poseen")
@Getter
@Setter
public class MonstruoHabilidad {

    @EmbeddedId
    private MonstruoHabilidadId id;

    @Column(name = "nivel_habilidad", nullable = false, columnDefinition = "INT DEFAULT 1")
    @Schema(description = "Nivel de la habilidad del monstruo", example = "1")
    private Integer nivelHabilidad;

    @Column(name = "probabilidad_uso", nullable = false, columnDefinition = "INT DEFAULT 100")
    @Schema(description = "Probabilidad de uso de la habilidad por el monstruo", example = "100")
    private Integer probabilidadUso;


    // Relación con la tabla monstruo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monstruo_id", insertable = false, updatable = false)
    private Monstruo monstruo;

    // Relación con la tabla habilidad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habilidad_id", insertable = false, updatable = false)
    private Habilidad habilidad;
}
