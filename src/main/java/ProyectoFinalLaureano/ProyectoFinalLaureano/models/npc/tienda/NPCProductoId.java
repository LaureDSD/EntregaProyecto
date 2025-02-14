package ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class NPCProductoId implements Serializable {
    private Long npc_id;
    private Long item_id;
}