package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.objetoDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ObjetoEfectoCompletoDTO {
    private Item objeto;
    private List<EfectoEstado> estadoList;
}
