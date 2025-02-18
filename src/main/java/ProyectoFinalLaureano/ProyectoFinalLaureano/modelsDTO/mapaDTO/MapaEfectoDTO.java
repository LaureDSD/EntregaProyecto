package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.mapaDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MapaEfectoDTO {

    private Mapa mapa;
    private List<EfectoEstado> estadoList;
}
