package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos;

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
@Schema(description = "Entidad que genera un ID apartir de MonstruoId y MapaId.")
public class MapaMonstruoId implements Serializable {
    private Long monstruo_id;
    private Long mapa_id;

    public MapaMonstruoId(Long monstruo_id, Long mapa_id) {
        this.monstruo_id = monstruo_id;
        this.mapa_id = mapa_id;
    }

}