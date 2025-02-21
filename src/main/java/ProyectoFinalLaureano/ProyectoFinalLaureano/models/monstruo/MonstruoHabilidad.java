package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monstruo_habilidad_id;

    //Nivel de la habilidad
    @Column(name = "nivel_habilidad", nullable = false)
    @Schema(description = "Nivel de la habilidad del monstruo", example = "1")
    private Long nivelHabilidad;

    //Posibilidad de acertar
    @Column(name = "probabilidad_uso", nullable = false)
    @Schema(description = "Probabilidad de uso de la habilidad por el monstruo", example = "100")
    private double probabilidadUso;

    //Posibilidad de fallar
    @Column(name = "probabilidad_fallo", nullable = false)
    @Schema(description = "Probabilidad de fallar de la habilidad por el monstruo", example = "100")
    private double probabilidadFallo;

    // Relación con la tabla monstruo N:1
    //@ManyToOne()
    //@Join
    @Column(name = "monstruo_id", insertable = false, updatable = false)
    private Long monstruo;

    // Relación con la tabla habilidad N:1
    //@ManyToOne()
    //@Join
    @Column(name = "habilidad_id", insertable = false, updatable = false)
    private Long habilidad;
}
