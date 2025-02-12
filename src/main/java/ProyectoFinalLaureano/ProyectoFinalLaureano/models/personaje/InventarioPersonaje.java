package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventario_personaje")
@Schema(description = "Entidad que representa el inventario de un personaje")
@Getter
@Setter
public class InventarioPersonaje {

    @EmbeddedId
    private InventarioPersonajeId id;

    @ManyToOne
    @MapsId("personaje_id")
    @JoinColumn(name = "personaje_id", nullable = false)
    @JsonIgnore
    @Schema(description = "Personaje asociado al inventario")
    private Personaje personaje;

    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem en el inventario")
    private Item item;

    @Column(name = "cantidad", nullable = false)
    @Schema(description = "Cantidad del ítem en el inventario", example = "1")
    private int cantidad;

    @Column(name = "equipado", nullable = false)
    @Schema(description = "Indica si el ítem está equipado", example = "false")
    private boolean equipado;

    @Column(name = "fecha_obtencion", nullable = false)
    @Schema(description = "Fecha y hora de obtención del ítem", example = "2023-10-01T12:00:00")
    private LocalDateTime fecha_obtencion;
}
