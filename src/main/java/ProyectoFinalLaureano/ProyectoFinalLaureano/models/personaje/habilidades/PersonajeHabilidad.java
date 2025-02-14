package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personaje_habilidad")
@Getter
@Setter
public class PersonajeHabilidad {

    @EmbeddedId
    private PersonajeHabilidadId id;

    @Column(name = "nivel_habilidad", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer nivelHabilidad;

    @Column(name = "probabilidad_uso", nullable = false, columnDefinition = "INT DEFAULT 100")
    private Integer probabilidadUso;

    // Relación con la tabla personaje
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaje_id", insertable = false, updatable = false)
    private Personaje personaje;

    // Relación con la tabla habilidad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habilidad_id", insertable = false, updatable = false)
    private Habilidad habilidad;
}