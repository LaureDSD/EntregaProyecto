package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

// (Correcto)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "logros_personaje")
@Schema(description = "Entidad que representa el registro de actividades de un personaje")
public class LogrosPersonaje {

    //ID del persoaje correspondiente
    @Id
    @Column(name = "personaje_id")
    @Schema(description = "ID único del personaje (clave foránea)", example = "1")
    private Long personaje_id;

    //Persoaje relacionado con latabla de logros
    @OneToOne
    @MapsId
    @JoinColumn(name = "personaje_id")
    @JsonIgnore
    @Schema(description = "Personaje asociado a estas estadísticas")
    private Personaje personaje;

    //Registro de monstruos normales cazados
    @Column(name = "normal", nullable = false)
    @Schema(description = "Número de enemigos normales derrotados", example = "10")
    private int normal;

    //Registro de miniboss  cazados
    @Column(name = "miniboss", nullable = false)
    @Schema(description = "Número de minibosses derrotados", example = "2")
    private int miniboss;

    //Registro de boss normales cazados
    @Column(name = "boss", nullable = false)
    @Schema(description = "Número de bosses derrotados", example = "1")
    private int boss;

    //Muertes totales del juegador
    @Column(name = "muertes_totales", nullable = false)
    @Schema(description = "Número total de muertes del personaje", example = "0")
    private int muertes_totales;

    //Daño total hecho por e jugador
    @Column(name = "total_daño_inflijido", nullable = false)
    @Schema(description = "Daño total infligido por el personaje", example = "500")
    private int total_daño_inflijido;

    //Daño total recivido
    @Column(name = "total_daño_recibido", nullable = false)
    @Schema(description = "Daño total recibido por el personaje", example = "200")
    private int total_daño_recibido;

    //Tiempo total de jeugo con el personaje
    @Column(name = "tiempo_total_jugado", nullable = false)
    @Schema(description = "Tiempo total jugado por el personaje (en segundos)", example = "3600")
    private int tiempo_total_jugado;

    //Mapas de tipo mazmorra completados
    @Column(name = "mazmorras_totales_superadas", nullable = false)
    @Schema(description = "Número total de mazmorras superadas", example = "1")
    private int mazmorras_totales_superadas;
}