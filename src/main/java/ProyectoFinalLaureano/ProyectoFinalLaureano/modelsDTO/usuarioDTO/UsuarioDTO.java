package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.usuarioDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    private String imagen;

    private String nombrePublico;

    private int persoanjesMax;

    private String nombrePrivado;

    private String correo;

    private String contrasena;

    private LocalDateTime conexion;

    private LocalDateTime fecha_creacion;

    private boolean estado;

    private TipoUsuario tipoUsuario;

    private List<PersonajeDTO> personajes;

}
