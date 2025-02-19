package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.recompensas;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//(Corrrecto)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mision_objetos")
@Schema(description = "Entidad que representa los objetos de recompensa de una misión")
public class MisionObjetos {

    //ID relacion
    @EmbeddedId
    private MisionObjetoId id;

    //Mision relacionada N:1
    @ManyToOne
    @MapsId("mision_id")
    @JoinColumn(name = "mision_id", nullable = false)
    @Schema(description = "Misión asociada a la recompensa")
    private Mision mision;

    //Item ralcionado N:1
    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem de recompensa")
    private Item item;

    //Cantidad que se ofrece por mison del objeto
    @Column(name = "cantidad", nullable = false)
    @Schema(description = "Cantidad del ítem de recompensa", example = "1")
    private int cantidad;

}
