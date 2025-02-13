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

    @Column(name = "vida_base", nullable = false)
    @Schema(description = "Vida base de la  clase", example = "100")
    private int vida_base;
    @Column(name = "escudo_base", nullable = false)
    @Schema(description = "Escudo base de la  clase", example = "0")
    private int escudo_base;


    @Column(name = "energia_base", nullable = false)
    @Schema(description = "Energía base de la clase", example = "50")
    private int energia_base;
    @Column(name = "mana_base", nullable = false)
    @Schema(description = "Mana base de la clase", example = "50")
    private int emana_base;


    @Column(name = "ataque_fisico_base", nullable = false)
    @Schema(description = "Ataque base de la clase", example = "10")
    private int ataquefiscobase;
    @Column(name = "ataque_magico_base", nullable = false)
    @Schema(description = "Ataque base de la clase", example = "10")
    private int ataqueMagicoBase;


    @Column(name = "defensa_fisica")
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensamagica;
    @Column(name = "defensa_magica")
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensafisica;
}
