package ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "habilidad_efecto")
@Schema(description = "Entidad que representa la relación entre una habilidad y un efecto")
@Getter
@Setter
public class HabilidadEfecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habilidad_efecto_id;

    //Relacion habilidad N:1
    @ManyToOne
    //@MapsId("habilidad_id")
    @JoinColumn(name = "habilidad_id", nullable = false)
    @Schema(description = "Habilidad asociada al efecto")
    private Habilidad habilidad;

    // Relacion efecto N:1
    @ManyToOne
    //@MapsId("efecto_id")
    @JoinColumn(name = "efecto_id", nullable = false)
    @Schema(description = "Efecto aplicado por la habilidad")
    private EfectoEstado efecto;
}