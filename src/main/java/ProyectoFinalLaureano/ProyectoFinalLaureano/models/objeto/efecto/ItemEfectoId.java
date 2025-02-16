package ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ItemEfectoId implements Serializable {
    private Long item_id;
    private Long efecto_id;

    public ItemEfectoId(Long item_id, Long efecto_id) {
        this.item_id = item_id;
        this.efecto_id = efecto_id;
    }
}
