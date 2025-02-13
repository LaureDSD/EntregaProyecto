package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class MisionObjetosId implements Serializable {
    private Long mision_id;
    private Long item_id;
}