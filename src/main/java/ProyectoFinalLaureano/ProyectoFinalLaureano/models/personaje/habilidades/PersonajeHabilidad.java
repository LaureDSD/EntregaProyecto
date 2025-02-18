package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "personaje_habilidad")
@Getter
@Setter
@Schema(description = "Entidad que genera que represenata la relacion entre persoanje y habilidad")
public class PersonajeHabilidad {

    //ID combinado de la relacion
    @EmbeddedId
    private PersonajeHabilidadId id;

    //Nivel de lahabilidad de la habilidad del persoanje
    @Column(name = "nivel_habilidad", nullable = false)
    @Schema(description = "Nivelde la habilidad asiganada", example = "10")
    private int nivelHabilidad;

    //Posibilidad de fallar
    @Column(name = "probabilidad_fallo", nullable = false)
    @Schema(description = "Probabilidad de fallar de la habilidad por el persoanje", example = "10")
    private double probabilidadFallo;

    // Relación con la tabla personaje
    @ManyToOne()
    @JoinColumn(name = "personaje_id", insertable = false, updatable = false)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private Personaje personaje;

    // Relación con la tabla habilidad
    @ManyToOne()
    @JoinColumn(name = "habilidad_id", insertable = false, updatable = false)
    private Habilidad habilidad;
}