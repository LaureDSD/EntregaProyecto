package ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "item_efecto")
@Schema(description = "Entidad que representa la relación entre un ítem y un efecto")
public class ItemEfecto {

    @EmbeddedId
    private ItemEfectoId id;

    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem asociado al efecto")
    private Item item;

    @ManyToOne
    @MapsId("efecto_id")
    @JoinColumn(name = "efecto_id", nullable = false)
    @Schema(description = "Efecto aplicado por el ítem")
    private EfectoEstado efecto;

}
