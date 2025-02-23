package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.ClasePersonaje;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.LogrosPersonaje;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PersonajeDTO {

    private Long id;

    private String imagen;

    private String nombre;

    private Date creacion;

    private int nivel;

    private int xp_acumulada;

    private int almas;

    private EstadisticasGenerales estadisticas;

    private LogrosPersonaje logros;

    private ClasePersonaje clase;

    private int capacidad_inventario;

    private List<InventarioDTO> inventario;

}
