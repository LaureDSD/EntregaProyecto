package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class InventarioPersonajeId implements Serializable {
    private Long personaje_id;
    private Long item_id;
}