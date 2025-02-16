package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades;

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

    public MonstruoHabilidadId(Long monstruo_id, Long habilidad_id) {
        this.monstruo_id = monstruo_id;
        this.habilidad_id = habilidad_id;
    }
}
