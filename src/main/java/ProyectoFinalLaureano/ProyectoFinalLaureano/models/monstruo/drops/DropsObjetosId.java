package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.drops;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class DropsObjetosId implements Serializable {
    private Long monstruo_id;
    private Long item_id;
}
