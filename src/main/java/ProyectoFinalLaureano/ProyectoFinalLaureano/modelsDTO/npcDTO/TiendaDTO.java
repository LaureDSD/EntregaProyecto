package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.Npc;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TiendaDTO {

    private Item item;

    private Npc npc;

    private int precioCompra;

    private int precioVenta;

    private int cantidadVenta;

}
