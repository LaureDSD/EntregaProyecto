package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.grupoDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class GrupoDTO {

    private long Id;

    private String imagen;

    private String nombre;

    private String descripcion;

    private String tipoGrupo;

    private PersonajeDTO lider;

    private List<PersonajeDTO> miembros;

}
