package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.efectosDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.enums.TipoAfectado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.enums.TipoEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasDTO;


public class EfectoDTO {

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
