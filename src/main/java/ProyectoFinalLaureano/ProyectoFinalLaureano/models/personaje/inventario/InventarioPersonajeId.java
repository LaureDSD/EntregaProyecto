package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario;
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
@Schema(description = "Entidad que genera un ID apartir de PersoanjeId y ItemId.")
public class InventarioPersonajeId implements Serializable {
    private Long personaje_id;
    private Long item_id;

    public InventarioPersonajeId(Long personaje_id, Long item_id) {
        this.personaje_id = personaje_id;
        this.item_id = item_id;
    }
}