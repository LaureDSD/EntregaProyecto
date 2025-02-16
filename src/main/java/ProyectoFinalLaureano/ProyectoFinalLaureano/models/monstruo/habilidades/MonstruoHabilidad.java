package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "monstruo_habilidad")
@Schema(description = "Entidad que representa la relación entre los monstruos y las habilidades que poseen")
@Getter
@Setter
public class MonstruoHabilidad {

    //ID de la relacion
    @EmbeddedId
    private MonstruoHabilidadId id;

    //Nivel de la habilidad
    @Column(name = "nivel_habilidad", nullable = false)
    @Schema(description = "Nivel de la habilidad del monstruo", example = "1")
    private int nivelHabilidad;

    //Posibilidad de acertar
    @Column(name = "probabilidad_uso", nullable = false)
    @Schema(description = "Probabilidad de uso de la habilidad por el monstruo", example = "100")
    private double probabilidadUso;

    //Posibilidad de fallar
    @Column(name = "probabilidad_fallo", nullable = false)
    @Schema(description = "Probabilidad de fallar de la habilidad por el monstruo", example = "100")
    private double probabilidadFallo;

    // Relación con la tabla monstruo N:1
    @ManyToOne()
    @JoinColumn(name = "monstruo_id", insertable = false, updatable = false)
    private Monstruo monstruo;

    // Relación con la tabla habilidad N:1
    @ManyToOne()
    @JoinColumn(name = "habilidad_id", insertable = false, updatable = false)
    private Habilidad habilidad;
}
