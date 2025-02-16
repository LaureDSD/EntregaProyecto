package ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
@Schema(description = "Entidad que genera un ID apartir de HabilidadId y EfectoId.")
public class HabilidadEfectoId implements Serializable {
    private Long habilidad_id;
    private Long efecto_id;

    public HabilidadEfectoId(Long habilidad_id, Long efecto_id) {
        this.habilidad_id = habilidad_id;
        this.efecto_id = efecto_id;
    }
}
