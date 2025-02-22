package ProyectoFinalLaureano.ProyectoFinalLaureano.models.item;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "item_efecto")
@Schema(description = "Entidad que representa la relación entre un ítem y un efecto")
@Getter
@Setter
public class ItemEfecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_efecto_id;

    //Item con el efecto
    @ManyToOne
    //@MapsId("item_id")
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem asociado al efecto")
    private Item item;

    //Efecto del item
    @ManyToOne
    //@MapsId("efecto_id")
    @JoinColumn(name = "efecto_id", nullable = false)
    @Schema(description = "Efecto aplicado por el ítem")
    private EfectoEstado efecto;
}
