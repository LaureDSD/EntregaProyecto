package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.habilidadDTO.HabilidadDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.itemDTO.ItemDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.mapaDTO.MapaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MonstruoDTO {

    private String nombre;

    private TipoMonstruo tipo;

    private int nivel;

    private String descripcion;

    private String imagen;

    private EstadisticasDTO estadisticas;

    private int almas;

    private int experiencia;

    private List<ItemDTO> drops;

    private List<MapaDTO> mapa;

    private List<HabilidadDTO> habilidades;

}
