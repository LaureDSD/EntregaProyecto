package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class PersonajeHabilidadId implements Serializable {
    private Long personaje_id;
    private Long habilidad_id;

    public PersonajeHabilidadId(Long personaje_id, Long habilidad_id) {
        this.personaje_id = personaje_id;
        this.habilidad_id = habilidad_id;
    }
}