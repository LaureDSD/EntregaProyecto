package ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;

import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.itemDTO.ItemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class InventarioDTO {

    private ItemDTO item;

    private int cantidad;

    private boolean equipado;

    private LocalDateTime fecha_obtencion;
}
