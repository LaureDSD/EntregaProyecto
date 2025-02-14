package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class MapaMonstruoId implements Serializable {
    private Long monstruo_id;
    private Long mapa_id;
}