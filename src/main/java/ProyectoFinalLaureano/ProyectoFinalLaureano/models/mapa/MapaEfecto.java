package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "mapa_efecto")
@Schema(description = "Entidad que representa la relación entre un mapa y un efecto")
public class MapaEfecto {

    @EmbeddedId
    private MapaEfectoId id;

    @ManyToOne
    @MapsId("mapa_id")
    @JoinColumn(name = "mapa_id", nullable = false)
    @Schema(description = "Mapa asociado al efecto")
    private Mapa mapa;

    @ManyToOne
    @MapsId("efecto_id")
    @JoinColumn(name = "efecto_id", nullable = false)
    @Schema(description = "Efecto aplicado en el mapa")
    private EfectoEstado efecto;

}
