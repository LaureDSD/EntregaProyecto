package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "estadisticas_personaje")
@Schema(description = "Entidad que representa las estadísticas de un personaje")
@Getter
@Setter
public class EstadisticasPersonaje {

    @Id
    @Column(name = "personaje_id")
    @Schema(description = "ID único del personaje (clave foránea)", example = "1")
    private Long personaje_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "personaje_id")
    @JsonIgnore
    @Schema(description = "Personaje asociado a estas estadísticas")
    private Personaje personaje;

    @Column(name = "nivel", nullable = false)
    @Schema(description = "Nivel del personaje", example = "1")
    private int nivel;

    @Column(name = "xp_acumulada", nullable = false)
    @Schema(description = "Experiencia acumulada del personaje", example = "0")
    private int xp_acumulada;

    @Column(name = "vida_base", nullable = false)
    @Schema(description = "Vida base del persoanje", example = "100")
    private int vida_base;
    @Column(name = "escudo_base", nullable = false)
    @Schema(description = "Escudo base del persoanje", example = "0")
    private int escudo_base;


    @Column(name = "energia_base", nullable = false)
    @Schema(description = "Energía base del persoanje", example = "50")
    private int energia_base;
    @Column(name = "mana_base", nullable = false)
    @Schema(description = "Mana base del persoanje", example = "50")
    private int emana_base;


    @Column(name = "ataque_fisico_base", nullable = false)
    @Schema(description = "Ataque base del persoanje", example = "10")
    private int ataquefiscobase;
    @Column(name = "ataque_magico_base", nullable = false)
    @Schema(description = "Ataque base del persoanje", example = "10")
    private int ataqueMagicoBase;

    @Column(name = "almas", nullable = false)
    @Schema(description = "Almas acumuladas por el personaje", example = "0")
    private int almas;

    @Column(name = "capacidad_inventario", nullable = false)
    @Schema(description = "Capacidad del inventario del personaje", example = "10")
    private int capacidad_inventario;
}