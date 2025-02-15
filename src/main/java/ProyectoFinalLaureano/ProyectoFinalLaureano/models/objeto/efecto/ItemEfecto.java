package ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

// (Correcto)

@Entity
@Table(name = "item_efecto")
@Schema(description = "Entidad que representa la relación entre un ítem y un efecto")
@Getter
@Setter
public class ItemEfecto {

    @EmbeddedId
    private ItemEfectoId id;

    //Item con el efecto
    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem asociado al efecto")
    private Item item;

    //Efecto del item
    @ManyToOne
    @MapsId("efecto_id")
    @JoinColumn(name = "efecto_id", nullable = false)
    @Schema(description = "Efecto aplicado por el ítem")
    private EfectoEstado efecto;
}
