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
}