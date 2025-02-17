package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.itemDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.efectosDTO.EfectoDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO.MonstruoDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO.NpcDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ItemDTO {

    private long Id;

    private String nombre;

    private TipoItem tipoItem;

    private String descripcion;

    private int acumulaciones;

    private List<EfectoDTO> efectos;

    private EstadisticasDTO estadisticas;

    private List<MonstruoDTO> monstruo;

    private List<NpcDTO> npc;

}
