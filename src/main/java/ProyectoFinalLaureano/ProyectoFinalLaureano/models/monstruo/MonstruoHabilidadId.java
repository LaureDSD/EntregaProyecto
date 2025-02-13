package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class MonstruoHabilidadId implements Serializable {
    private Long monstruo_id;
    private Long habilidad_id;
}
