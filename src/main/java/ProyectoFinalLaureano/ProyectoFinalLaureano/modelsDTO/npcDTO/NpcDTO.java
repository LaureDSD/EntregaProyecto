package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.itemDTO.ItemDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO.MisionDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class NpcDTO {

    private long Id;

    private String nombre;

    private String descripcion;

    private String imagen;

    private TipoNPC tipoNPC;

    private List<ItemDTO> tienda;

    private List<MisionDTO> misiones;

}
