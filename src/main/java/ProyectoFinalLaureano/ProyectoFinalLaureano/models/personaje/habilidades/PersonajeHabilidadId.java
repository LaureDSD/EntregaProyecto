package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades;

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
@Schema(description = "Entidad que genera un ID apartir de PersoanjeId y HabilidadId.")
public class PersonajeHabilidadId implements Serializable {
    private Long personaje_id;
    private Long habilidad_id;

    public PersonajeHabilidadId(Long personaje_id, Long habilidad_id) {
        this.personaje_id = personaje_id;
        this.habilidad_id = habilidad_id;
    }
}