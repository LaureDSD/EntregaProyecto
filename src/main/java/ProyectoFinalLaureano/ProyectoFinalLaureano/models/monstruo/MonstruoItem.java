package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Entity
@Table(name = "drops_objetos")
@Schema(description = "Entidad que representa los objetos que un monstruo puede soltar")
@Getter
@Setter
public class MonstruoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monstruo_item_id;

    @ManyToOne
    //@MapsId("monstruo_id") /
    @JoinColumn(name = "monstruo_id", nullable = false)
    @Schema(description = "Monstruo asociado al drop")
    private Monstruo monstruo;

    @ManyToOne
    //@MapsId("item_id")
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem que puede ser soltado")
    private Item item;

    @Column(name = "probabilidad", nullable = false)
    @Schema(description = "Probabilidad de que el objeto sea soltado", example = "100")
    private int probabilidad;
}

