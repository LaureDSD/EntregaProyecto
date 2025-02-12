package ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones_npc_personaje")
@Schema(description = "Entidad que representa una transacción entre un NPC y un personaje")
@Getter
@Setter
public class TransaccionesNPC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la transacción", example = "1")
    private Long transaccion_id;

    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = false)
    @Schema(description = "Personaje asociado a la transacción")
    private Personaje personaje;

    @ManyToOne
    @JoinColumn(name = "npc_id", nullable = false)
    @Schema(description = "NPC asociado a la transacción")
    private NPC npc;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem involucrado en la transacción")
    private Item item;

    @Column(name = "tipo_transaccion", nullable = false)
    @Schema(description = "Tipo de transacción (compra/venta)", example = "compra")
    private String tipo_transaccion;

    @Column(name = "cantidad", nullable = false)
    @Schema(description = "Cantidad de ítems involucrados en la transacción", example = "1")
    private int cantidad;

    @Column(name = "precio_almas", nullable = false)
    @Schema(description = "Precio en almas de la transacción", example = "50")
    private int precio_almas;

    @Column(name = "fecha_transaccion", nullable = false)
    @Schema(description = "Fecha y hora de la transacción", example = "2023-10-01T12:00:00")
    private LocalDateTime fecha_transaccion;
}
