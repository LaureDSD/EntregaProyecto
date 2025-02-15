package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

// (Corecto)

@Entity
@Table(name = "mapa_efecto")
@Schema(description = "Entidad que representa la relación entre un mapa y un efecto")
@Getter
@Setter
public class MapaEfecto {

    // ID de la relacion
    @EmbeddedId
    private MapaEfectoId id;

    //Mapa relacionado N:1
    @ManyToOne
    @MapsId("mapa_id")
    @JoinColumn(name = "mapa_id", nullable = false)
    @Schema(description = "Mapa asociado al efecto")
    private Mapa mapa;

    //Efecto relacionado N:1
    @ManyToOne
    @MapsId("efecto_id")
    @JoinColumn(name = "efecto_id", nullable = false)
    @Schema(description = "Efecto aplicado en el mapa")
    private EfectoEstado efecto;
}
