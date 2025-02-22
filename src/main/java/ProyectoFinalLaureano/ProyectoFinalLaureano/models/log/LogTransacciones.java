package ProyectoFinalLaureano.ProyectoFinalLaureano.models.log;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoTransaccion;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.Npc;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;


// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "transacciones_npc_personaje")
@Schema(description = "Entidad que representa una transacción entre un NPC y un personaje")
@Getter
@Setter
public class LogTransacciones {

    //ID  del la transaccion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la transacción", example = "1")
    private Long transaccion_id;

    //Persoanje de la realcion N:1
    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = false)
    //@Column(name = "personaje_id", nullable = false)
    @Schema(description = "Personaje asociado a la transacción")
    private Personaje personaje;

    //NPC de la relacion N:1
    @ManyToOne
    @JoinColumn(name = "npc_id", nullable = false)
    //@Column(name = "npc_id", nullable = false)
    @Schema(description = "NPC asociado a la transacción")
    private Npc npc;

    //Item dela realcion N:1
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    //@Column(name = "item_id", nullable = false)
    @Schema(description = "Ítem involucrado en la transacción")
    private Item item;

    //Tipo de la transacion
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transaccion", nullable = false)
    @Schema(description = "Tipo de transacción (compra/venta)", example = "compra")
    private TipoTransaccion tipoTransaccion;

    //Cantidad de transaccion
    @Column(name = "cantidad", nullable = false)
    @Schema(description = "Cantidad de ítems involucrados en la transacción", example = "1")
    private int cantidad;

    //Almas usadas en la transaccion
    @Column(name = "precio_almas", nullable = false)
    @Schema(description = "Precio en almas de la transacción", example = "50")
    private int precio_almas;

    //Fecha de transacion
    @Column(name = "fecha_transaccion", nullable = false)
    @Schema(description = "Fecha y hora de la transacción", example = "2023-10-01T12:00:00")
    private LocalDateTime fecha_transaccion;
}
