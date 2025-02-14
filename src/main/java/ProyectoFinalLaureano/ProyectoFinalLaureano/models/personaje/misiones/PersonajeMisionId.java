package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class PersonajeMisionId implements Serializable {
    private Long personaje_id;
    private Long mision_id;
}
