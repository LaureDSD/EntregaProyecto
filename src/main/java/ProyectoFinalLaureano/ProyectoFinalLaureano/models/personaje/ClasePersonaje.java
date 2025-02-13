package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;


@Entity
@Table(name = "clase_persoanje")
@Schema(description = "Entidad que representa ula clase de personaje")
@Getter
@Setter
public class ClasePersonaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de clase", example = "1")
    private Long clase_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre de la clase", example = "Mago")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del la clase", example = "Especialista en ehchizos y ataques a larga distabcia")
    private String descripcion;

    @Column(name = "vida_base", nullable = false)
    @Schema(description = "Vida base de la  clase", example = "100")
    private int vida_base;

    @Column(name = "energia_base", nullable = false)
    @Schema(description = "Energía base de la clase", example = "50")
    private int energia_base;

    @Column(name = "mana_base", nullable = true)
    @ColumnDefault("50")
    @Schema(description = "Mana base de la clase", example = "50")
    private int emana_base;

    @Column(name = "ataque_base", nullable = false)
    @Schema(description = "Ataque base de la clase", example = "10")
    private int ataque_base;

    @Column(name = "defensa")
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensa;

    // Relación Uno a Muchos con persoanje
    @OneToMany(mappedBy = "clase_persoanje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Persoanjes asociados a este tipo")
    private List<Personaje> persoanjes;

}