package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RecompensaDTO {
    private Item item;
    private int cantidad;
}
