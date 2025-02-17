package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.mapaDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.efectosDTO.EfectoDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO.MonstruoDTO;


import java.util.List;

public class MapaDTO {

    private String nombre;

    private String descripcion;

    private String imagen;

    private TipoMapa tipoMapa;

    private int nivel_recomendado;

    private List<EfectoDTO> efectos;

    private List<MonstruoDTO> mapaMonstruos;

}
