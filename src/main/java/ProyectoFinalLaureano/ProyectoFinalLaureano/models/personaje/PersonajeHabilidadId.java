package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

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
}