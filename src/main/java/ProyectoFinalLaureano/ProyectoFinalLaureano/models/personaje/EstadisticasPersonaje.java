package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Getter
@Setter
@Entity
@Table(name = "estadisticas_personaje")
@Schema(description = "Entidad que representa las estadísticas de un personaje")
public class EstadisticasPersonaje {

    //ID del persoaje correspondiente
    @Id
    @Column(name = "personaje_id")
    @Schema(description = "ID único del personaje (clave foránea)", example = "1")
    private Long personaje_id;

    //Persoanje relacion 1:1
    @OneToOne
    @MapsId
    @JoinColumn(name = "personaje_id")
    @JsonIgnore
    @Schema(description = "Personaje asociado a estas estadísticas")
    private Personaje personaje;

    //Nivel del persoanje
    @Column(name = "nivel", nullable = false)
    @Schema(description = "Nivel del personaje", example = "1")
    private int nivel;

    //EXP del persoanje
    @Column(name = "xp_acumulada", nullable = false)
    @Schema(description = "Experiencia acumulada del personaje", example = "0")
    private int xp_acumulada;

    //Vida Base del personaje
    @Column(name = "vida_base", nullable = false)
    @Schema(description = "Vida base del persoanje", example = "100")
    private int vida_base;

    //Escudo base del persoanje
    @Column(name = "escudo_base", nullable = false)
    @Schema(description = "Escudo base del persoanje", example = "0")
    private int escudo_base;

    //Energia base del persoanje
    @Column(name = "energia_base", nullable = false)
    @Schema(description = "Energía base del persoanje", example = "50")
    private int energia_base;

    //Mana base del personaje
    @Column(name = "mana_base", nullable = false)
    @Schema(description = "Mana base del persoanje", example = "50")
    private int mana_base;

    //Ataque fisico base del personaje
    @Column(name = "ataque_fisico_base", nullable = false)
    @Schema(description = "Ataque base del persoanje", example = "10")
    private int ataquefiscobase;

    //Ataque magico base del personaje
    @Column(name = "ataque_magico_base", nullable = false)
    @Schema(description = "Ataque base del persoanje", example = "10")
    private int ataqueMagicoBase;

    //Defensa magica  basica del personaje
    @Column(name = "defensa_fisica", nullable = false)
    @Schema(description = "Defensa del personaje", example = "5")
    private int defensamagica;

    //Defensa fisica  basica del personaje
    @Column(name = "defensa_magica", nullable = false)
    @Schema(description = "Defensa del personaje", example = "5")
    private int defensafisica;

    //Almas acumuladas por el personaje
    @Column(name = "almas", nullable = false)
    @Schema(description = "Almas acumuladas por el personaje", example = "0")
    private int almas;

    //Limite de inventario del personaje
    @Column(name = "capacidad_inventario", nullable = false)
    @Schema(description = "Capacidad del inventario del personaje", example = "20")
    private int capacidad_inventario;
}