package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// (Corecto)
@NoArgsConstructor
@Entity
@Table(name = "mapa_efecto")
@Schema(description = "Entidad que representa la relación entre un mapa y un efecto")
@Getter
@Setter
public class MapaEfecto {

    // ID de la relacion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  mapa_efecto_id;

    //Mapa relacionado N:1
    @ManyToOne
    //@MapsId("mapa_id")
    @JoinColumn(name = "mapa_id", nullable = false)
    @Schema(description = "Mapa asociado al efecto")
    private Mapa mapa;

    //Efecto relacionado N:1
    @ManyToOne
    //@MapsId("efecto_id")
    @JoinColumn(name = "efecto_id", nullable = false)
    @Schema(description = "Efecto aplicado en el mapa")
    private EfectoEstado efecto;
}
