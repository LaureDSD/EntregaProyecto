package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades;

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
@Schema(description = "Entidad que genera un ID apartir de MonstruoId y HabilidadId.")
public class MonstruoHabilidadId implements Serializable {
    private Long monstruo_id;
    private Long habilidad_id;

    public MonstruoHabilidadId(Long monstruo_id, Long habilidad_id) {
        this.monstruo_id = monstruo_id;
        this.habilidad_id = habilidad_id;
    }
}
