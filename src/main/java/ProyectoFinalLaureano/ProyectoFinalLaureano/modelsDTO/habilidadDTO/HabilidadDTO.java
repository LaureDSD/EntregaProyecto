package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.habilidadDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.ObjetivoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;

import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.efectosDTO.EfectoDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasSimpleDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO.MonstruoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class HabilidadDTO {

    private long Id;

    private String imagen;

    private String nombre;

    private String descripcion;

    private int nivel_maximo;

    private int requisito_nivel;

    private TipoHabilidad tipoHabilidad;

    private ObjetivoHabilidad objetivoHabilidad;

    private double area;

    private int unidades;

    private EstadisticasSimpleDTO estadisticas;

    private int enfriamiento;

    private List<EfectoDTO> efectos;

    private List<MonstruoDTO> monstruos;

}
