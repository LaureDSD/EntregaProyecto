package ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda;

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
@Schema(description = "Entidad compuesta de lso id de NPC e Item.")
public class NPCProductoId implements Serializable {
    private Long npc_id;
    private Long item_id;

    public NPCProductoId(Long npc_id, Long item_id) {
        this.npc_id = npc_id;
        this.item_id = item_id;
    }
}