package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones;

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
@Schema(description = "Entidad que genera un ID apartir de PersoanjeId y MisionId.")
public class PersonajeMisionId implements Serializable {
    private Long personaje_id;
    private Long mision_id;

    public PersonajeMisionId(Long personaje_id, Long mision_id) {
        this.personaje_id = personaje_id;
        this.mision_id = mision_id;
    }
}
