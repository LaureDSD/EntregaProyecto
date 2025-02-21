package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "mapa_monstruos")
@Schema(description = "Entidad que representa la relación entre los mapas y los monstruos con su probabilidad de aparición")
@Getter
@Setter
public class MapaMonstruo {

    //ID relacion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mapa_monstruo_id;

    //Posibilidad e aparicion
    @Column(name = "probabilidad_aparicion")
    @Schema(description = "Probabilidad de aparición del monstruo en el mapa", example = "75")
    private Integer probabilidadAparicion;

    // Relación con la tabla mapa N:1
    //@ManyToOne()
    //@JoinColumn(name = "mapa_id", insertable = false, updatable = false)
    //@Column(name = "mapa_id", insertable = false, updatable = false)
    @Schema(description = "Nombre del mapa", example = "2")
    private Long mapa;

    // Relación con la tabla monstruo N:1
    //@ManyToOne()
    //@JoinColumn(name = "monstruo_id", insertable = false, updatable = false)
    //@Column(name = "monstruo_id", insertable = false, updatable = false)
    @Schema(description = "Nombre del monstruo", example = "1")
    private Long monstruo;
}
