package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TiendaDTO {

    private Item item;

    private int precioCompra;

    private int precioVenta;

    private int cantidadVenta;

}
