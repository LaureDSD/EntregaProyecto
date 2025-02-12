package ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estadisticas_equipamiento")
@Schema(description = "Entidad que representa las estadísticas de un equipamiento")
@Getter
@Setter
public class EstadisticasEquipamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del equipamiento", example = "1")
    private Long equipamiento_id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    @Schema(description = "Ítem asociado a estas estadísticas")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "tipo_equipamiento_id", nullable = false)
    @Schema(description = "Tipo de equipamiento asociado")
    private TipoEquipamiento tipo_equipamiento;

    @Column(name = "ataque")
    @Schema(description = "Ataque del equipamiento", example = "10")
    private int ataque;

    @Column(name = "defensa")
    @Schema(description = "Defensa del equipamiento", example = "5")
    private int defensa;

    @Column(name = "vida")
    @Schema(description = "Vida del equipamiento", example = "0")
    private int vida;

    @Column(name = "energia")
    @Schema(description = "Energía del equipamiento", example = "0")
    private int energia;
}
