package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MisonObjetoDTO {
    private Mision mision;
    private RecompensaDTO recompensaDTO;
}
