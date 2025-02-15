package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// (Correcto)

@Entity
@Table(name = "mapa_monstruos")
@Schema(description = "Entidad que representa la relación entre los mapas y los monstruos con su probabilidad de aparición")
@Getter
@Setter
public class MapaMonstruo {

    //ID relacion
    @EmbeddedId
    private MapaMonstruoId id;

    //Posibilidad e aparicion
    @Column(name = "probabilidad_aparicion", nullable = false)
    @Schema(description = "Probabilidad de aparición del monstruo en el mapa", example = "75")
    private Integer probabilidadAparicion;

    // Relación con la tabla mapa N:1
    @ManyToOne()
    @JoinColumn(name = "mapa_id", insertable = false, updatable = false)
    private Mapa mapa;

    // Relación con la tabla monstruo N:1
    @ManyToOne()
    @JoinColumn(name = "monstruo_id", insertable = false, updatable = false)
    private Monstruo monstruo;
}
