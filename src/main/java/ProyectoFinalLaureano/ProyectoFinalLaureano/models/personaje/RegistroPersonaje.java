package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "registro_personaje")
@Schema(description = "Entidad que representa el registro de actividades de un personaje")
@Getter
@Setter
public class RegistroPersonaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del registro", example = "1")
    private Long registro_id;

    // Relación Muchos a Uno con Personaje
    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = false)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Personaje asociado a este registro")
    private Personaje personaje;

    @Column(name = "normal", nullable = false)
    @Schema(description = "Número de enemigos normales derrotados", example = "10")
    private int normal;

    @Column(name = "miniboss", nullable = false)
    @Schema(description = "Número de minibosses derrotados", example = "2")
    private int miniboss;

    @Column(name = "boss", nullable = false)
    @Schema(description = "Número de bosses derrotados", example = "1")
    private int boss;

    @Column(name = "muertes_totales", nullable = false)
    @Schema(description = "Número total de muertes del personaje", example = "0")
    private int muertes_totales;

    @Column(name = "total_daño_inflijido", nullable = false)
    @Schema(description = "Daño total infligido por el personaje", example = "500")
    private int total_daño_inflijido;

    @Column(name = "total_daño_recibido", nullable = false)
    @Schema(description = "Daño total recibido por el personaje", example = "200")
    private int total_daño_recibido;

    @Column(name = "tiempo_total_jugado", nullable = false)
    @Schema(description = "Tiempo total jugado por el personaje (en segundos)", example = "3600")
    private int tiempo_total_jugado;

    @Column(name = "mazmorras_totales_superadas", nullable = false)
    @Schema(description = "Número total de mazmorras superadas", example = "1")
    private int mazmorras_totales_superadas;
}