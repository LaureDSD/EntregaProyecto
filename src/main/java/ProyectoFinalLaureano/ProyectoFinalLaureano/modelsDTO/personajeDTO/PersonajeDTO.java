package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.LogrosPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasPersonajeDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.grupoDTO.GrupoDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.habilidadDTO.HabilidadDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.itemDTO.ItemDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO.MisionDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.usuarioDTO.UsuarioDTO;
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

    private String imagen;

    private String nombre;

    private LocalDateTime creacion;

    private int nivel;

    private int xp_acumulada;

    private int almas;

    private EstadisticasPersonajeDTO estadisticas;

    private LogrosPersonaje logros;

    private ClaseDTO clase;

    private GrupoDTO grupo;

    private UsuarioDTO usuario;

    private int capacidad_inventario;

    private List<InventarioDTO> inventario;

    private List<HabilidadDTO> personajeHabilidades;

    private List<MisionDTO> misiones;


}
