package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.recompensas;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "mision_objetos")
@Schema(description = "Entidad que representa los objetos de recompensa de una misión")
public class MisionObjetos {

    @EmbeddedId
    private MisionObjetoId id;

    @ManyToOne
    @MapsId("mision_id")
    @JoinColumn(name = "mision_id", nullable = false)
    @Schema(description = "Misión asociada a la recompensa")
    private Mision mision;

    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem de recompensa")
    private Item item;

    @Column(name = "cantidad", nullable = false)
    @Schema(description = "Cantidad del ítem de recompensa", example = "1")
    private int cantidad;

}
