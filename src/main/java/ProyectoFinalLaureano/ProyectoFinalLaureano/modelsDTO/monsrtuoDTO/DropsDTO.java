package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DropsDTO {
    private Item item;
    private int probabilidad;
}
