package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.itemDTO.ItemDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO.NpcDTO;


import java.util.List;

public class MisionDTO {

    private String nombre;

    private String descripcion;

    private int nivel;

    private int almas;

    private int experiencia;

    private int tiempo;

    private List<ItemDTO> recompensas;

    private List<NpcDTO> npcs;

}
