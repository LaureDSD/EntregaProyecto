package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.LogrosPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasPersonajeDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.grupoDTO.GrupoDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.habilidadDTO.HabilidadDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.itemDTO.ItemDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO.MisionDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PersonajeDTO {

    private Long id;

    private String imagen_modelo;

    private String nombre;

    private LocalDateTime fecha_creacion;

    private int nivel;

    private int xp_acumulada;

    private int almas;

    private int capacidad_inventario;

    private EstadisticasPersonajeDTO estadisticas;

    private Usuario usuario;

    private LogrosPersonaje logros;

    private ClaseDTO clase_persoanje;

    private GrupoDTO grupo;

    private List<ItemDTO> inventario;

    private List<HabilidadDTO> personajeHabilidades;

    private List<MisionDTO> misiones;

}
