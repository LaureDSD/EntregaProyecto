package ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// (Correcto)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clase_personaje")
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

    //RelacionCon Estadisticas
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadisticas_id", referencedColumnName = "estadisticasId")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private EstadisticasGenerales estadisticas;

    // Relación Uno a Muchos con persoanje
    @OneToMany(mappedBy = "clase_persoanje", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Persoanjes asociados a este tipo")
    private List<Personaje> persoanjes;

}