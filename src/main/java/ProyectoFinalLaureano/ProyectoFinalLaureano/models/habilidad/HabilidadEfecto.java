package ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "habilidad_efecto")
@Schema(description = "Entidad que representa la relación entre una habilidad y un efecto")
@Getter
@Setter
public class HabilidadEfecto {

    @EmbeddedId
    private HabilidadEfectoId id;

    @ManyToOne
    @MapsId("habilidad_id")
    @JoinColumn(name = "habilidad_id", nullable = false)
    @Schema(description = "Habilidad asociada al efecto")
    private Habilidad habilidad;

    @ManyToOne
    @MapsId("efecto_id")
    @JoinColumn(name = "efecto_id", nullable = false)
    @Schema(description = "Efecto aplicado por la habilidad")
    private EfectoEstado efecto;
}