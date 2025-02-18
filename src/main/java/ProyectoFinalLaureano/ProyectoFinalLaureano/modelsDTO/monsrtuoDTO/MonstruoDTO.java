package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MonstruoDTO {

    private long Id;

    private String nombre;

    private TipoMonstruo tipo;

    private int nivel;

    private String descripcion;

    private String imagen;

    private EstadisticasGenerales estadisticas;

    private int almas;

    private int experiencia;

    private List<DropsDTO> drops;

}
