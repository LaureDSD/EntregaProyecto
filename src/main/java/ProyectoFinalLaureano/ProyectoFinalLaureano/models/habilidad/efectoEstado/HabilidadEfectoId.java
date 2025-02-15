package ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class HabilidadEfectoId implements Serializable {
    private Long habilidad_id;
    private Long efecto_id;

    public HabilidadEfectoId(Long habilidad_id, Long efecto_id) {
        this.habilidad_id = habilidad_id;
        this.efecto_id = efecto_id;
    }
}
