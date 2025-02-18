package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.drops;

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
@Schema(description = "Entidad que genera un ID apartir de MonstruoId y ItemId.")
public class DropsObjetosId implements Serializable {
    private Long monstruoId;
    private Long item_id;

    public DropsObjetosId(Long monstruoId, Long item_id) {
        this.monstruoId = monstruoId;
        this.item_id = item_id;
    }
}
