package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MisionDTO {

    private long Id;

    private String nombre;

    private String descripcion;

    private int nivel;

    private int almas;

    private int experiencia;

    private int tiempo;

    private List<RecompensaDTO> recompensas;

}
