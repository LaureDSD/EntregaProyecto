package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class MapaEfectoId implements Serializable {
    private Long mapa_id;
    private Long efecto_id;

    public MapaEfectoId(Long mapa_id, Long efecto_id) {
        this.mapa_id = mapa_id;
        this.efecto_id = efecto_id;
    }
}