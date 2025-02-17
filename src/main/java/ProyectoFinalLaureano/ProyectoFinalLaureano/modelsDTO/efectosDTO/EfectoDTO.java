package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.efectosDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.enums.TipoAfectado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.enums.TipoEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EfectoDTO {

    private long Id;

    private String icono;

    private String nombre;

    private String descripcion;

    private TipoEfecto tipo;

    private TipoAfectado objetivo;

    private double duracion;

    private double intervalos;

    private int acumulaciones;

    private EstadisticasDTO estadisticas;

}
