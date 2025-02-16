package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.recompensas;

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
public class MisionObjetoId implements Serializable {
    private Long mision_id;
    private Long item_id;

    public MisionObjetoId(Long mision_id, Long item_id) {
        this.mision_id = mision_id;
        this.item_id = item_id;
    }
}