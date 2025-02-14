package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clase_persoanje")
@Schema(description = "Entidad que representa ula clase de personaje")
public class ClasePersonaje {

    //ID de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de clase", example = "1")
    private Long clase_id;

    //Nombre de la clase
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre de la clase", example = "Mago")
    private String nombre;

    //Descripcion de la clase
    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del la clase", example = "Especialista en ehchizos y ataques a larga distabcia")
    private String descripcion;

    //Vida base de la clase
    @Column(name = "vida_base", nullable = false)
    @Schema(description = "Vida base de la  clase", example = "100")
    private int vida_base;

    //Escudo base de la clase
    @Column(name = "escudo_base", nullable = false)
    @Schema(description = "Escudo base de la  clase", example = "0")
    private int escudo_base;

    //Energia base de la clase
    @Column(name = "energia_base", nullable = false)
    @Schema(description = "Energía base de la clase", example = "50")
    private int energia_base;

    //Mana base de cada clase
    @Column(name = "mana_base", nullable = false)
    @Schema(description = "Mana base de la clase", example = "50")
    private int emana_base;

    //Ataque fisico base d ecada clase
    @Column(name = "ataque_fisico_base", nullable = false)
    @Schema(description = "Ataque base de la clase", example = "10")
    private int ataquefiscobase;

    //Ataque magoco de cada clase
    @Column(name = "ataque_magico_base", nullable = false)
    @Schema(description = "Ataque base de la clase", example = "10")
    private int ataqueMagicoBase;

    //Defensa fisica de cada clase
    @Column(name = "defensa_fisica", nullable = false)
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensamagica;

    //Defensa magica de cada clase
    @Column(name = "defensa_magica", nullable = false)
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensafisica;

    // Relación Uno a Muchos con persoanje
    @OneToMany(mappedBy = "clase_persoanje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Persoanjes asociados a este tipo")
    private List<Personaje> persoanjes;

}