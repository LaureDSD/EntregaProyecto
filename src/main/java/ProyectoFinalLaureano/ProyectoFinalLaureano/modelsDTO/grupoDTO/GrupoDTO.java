package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.grupoDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersoanjeDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class GrupoDTO {

    private String imagen;

    private String nombre;

    private String descripcion;

    private String tipoGrupo;

    private PersoanjeDTO lider;

    private List<PersoanjeDTO> miembros;

}
