package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.usuarioDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String imagen;
    private String nombrePublico;
    private int limitePersoanjes;
    private String nombrePrivado;
    private String correo;
    private String contrasena;
    private Date conexion;
    private Date fecha_creacion;
    private boolean estado;
    private TipoUsuario tipoUsuario;
}
