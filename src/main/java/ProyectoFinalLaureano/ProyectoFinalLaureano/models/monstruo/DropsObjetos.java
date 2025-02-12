package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "drops_objetos")
@Schema(description = "Entidad que representa los objetos que un monstruo puede soltar")
@Getter
@Setter
public class DropsObjetos {

    @EmbeddedId
    private DropsObjetosId id;

    @ManyToOne
    @MapsId("monstruo_id") // Mapea la parte de monstruo_id de la clave compuesta
    @JoinColumn(name = "monstruo_id", nullable = false)
    @Schema(description = "Monstruo asociado al drop")
    private Monstruo monstruo;

    @ManyToOne
    @MapsId("item_id") // Mapea la parte de item_id de la clave compuesta
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem que puede ser soltado")
    private Item item;

    @Column(name = "probabilidad", nullable = false)
    @Schema(description = "Probabilidad de que el objeto sea soltado", example = "100")
    private int probabilidad;
}

