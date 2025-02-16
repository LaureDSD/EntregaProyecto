package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados;

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
@Schema(description = "Entidad que genera un ID apartir de MapaeId y EfectoId.")
public class MapaEfectoId implements Serializable {
    private Long mapa_id;
    private Long efecto_id;

    public MapaEfectoId(Long mapa_id, Long efecto_id) {
        this.mapa_id = mapa_id;
        this.efecto_id = efecto_id;
    }
}