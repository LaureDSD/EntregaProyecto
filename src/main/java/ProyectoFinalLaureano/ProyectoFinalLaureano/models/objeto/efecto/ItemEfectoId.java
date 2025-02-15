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
}
