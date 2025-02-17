package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasSimpleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ClaseDTO {

    private long Id;

    private String imagen;

    private String nombre;

    private String descripcion;

    private EstadisticasSimpleDTO estadisticas;

    private List<PersonajeDTO> persoanjes;

}
