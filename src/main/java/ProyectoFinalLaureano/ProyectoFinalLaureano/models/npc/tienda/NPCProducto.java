package ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "npc_producto")
@Schema(description = "Entidad que representa los productos que un NPC puede vender o comprar")
@Getter
@Setter
public class NPCProducto {

    //ID de la relacion
    @EmbeddedId
    private NPCProductoId id;

    //Precio al que compra el npc
    @Column(name = "precio_compra", nullable = false)
    @Schema(description = "Precio al que el NPC compra el ítem", example = "500")
    private Integer precioCompra;

    //Precio de venta del npc
    @Column(name = "precio_venta", nullable = false)
    @Schema(description = "Precio al que el NPC vende el ítem", example = "700")
    private Integer precioVenta;

    //Cantidad disponible para venta (Suma la comprada)
    @Column(name = "cantidad_venta", nullable = false)
    @Schema(description = "Cantidad de ítems disponibles para la venta por el NPC", example = "50")
    private Integer cantidadVenta;

    // Relación con la tabla npc N:1
    @ManyToOne()
    @JoinColumn(name = "npc_id", insertable = false, updatable = false)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private NPC npc;

    // Relación con la tabla items N:1
    @ManyToOne()
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private Item item;
}
