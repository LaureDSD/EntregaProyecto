package ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.ClasePersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "gremios")
@Schema(description = "Entidad que representa ula clase de personaje")
@Getter
@Setter
public class Gremio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de gremio", example = "1")
    private Long gremio_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del gremio", example = "Imperial")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del gremio", example = "Gremio de cazadores")
    private String descripcion;

    //Gremio
    /*
    @ManyToOne
    @JoinColumn(name = "liderDeGremio" , nullable = false)
    @Schema(description = "Lider del gremio")
    private Personaje lider_gremio;

    @OneToMany(mappedBy = "gremio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Personajes asociados a este gremio")
    private List<Personaje> persoanjes;
*/

}
