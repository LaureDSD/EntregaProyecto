package ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.efecto;

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
@Schema(description = "Entidad que genera un ID apartir de ItemId y EfectoId.")
public class ItemEfectoId implements Serializable {
    private Long item_id;
    private Long efecto_id;

    public ItemEfectoId(Long item_id, Long efecto_id) {
        this.item_id = item_id;
        this.efecto_id = efecto_id;
    }
}
