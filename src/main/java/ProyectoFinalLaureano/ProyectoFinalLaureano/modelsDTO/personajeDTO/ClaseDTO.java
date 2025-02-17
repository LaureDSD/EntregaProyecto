package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ClaseDTO {

    private String nombre;

    private String descripcion;

    private EstadisticasGenerales estadisticas;

    private List<PersoanjeDTO> persoanjes;

}
