package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.itemDTO.ItemDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO.MisionDTO;

import java.util.List;

public class NpcDTO {

    private String nombre;

    private String descripcion;

    private String imagen;

    private TipoNPC tipoNPC;

    private List<ItemDTO> tienda;

    private List<MisionDTO> misiones;

}
