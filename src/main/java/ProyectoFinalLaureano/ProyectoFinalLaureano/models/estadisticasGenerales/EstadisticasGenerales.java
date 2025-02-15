package ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.equipamiento.Equipamiento;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.ClasePersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// (Correcto)

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estadisticas_generales")
@Schema(description = "Modelo que representa las estadísticas generales de un personaje, monstruo o efecto.")
public class EstadisticasGenerales {

    //ID de las estadisticas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de las estadísticas generales.", example = "1")
    private Long estadisticasId;

    //Vida base de todo
    @Schema(description = "Vida base de la entidad.", example = "100")
    private Integer vidaBase;

    @Schema(description = "Regeneración de vida base por intervalo de tiempo.", example = "5")
    private Integer regeneracionVidaBase;

    @Schema(description = "Escudo base de la entidad.", example = "50")
    private Integer escudoBase;

    @Schema(description = "Energía base de la entidad.", example = "100")
    private Integer energiaBase;

    @Schema(description = "Regeneración de energía base por intervalo de tiempo.", example = "10")
    private Integer regeneracionEnergiaBase;

    @Schema(description = "Maná base entidad.", example = "100")
    private Integer manaBase;

    @Schema(description = "Regeneración de maná base por intervalo de tiempo.", example = "5")
    private Integer regeneracionManaBase;

    @Schema(description = "Ataque físico base entidad.", example = "20")
    private Integer ataqueFisicoBase;

    @Schema(description = "Ataque mágico base entidad", example = "15")
    private Integer ataqueMagicoBase;

    @Schema(description = "Defensa física entidad.", example = "10")
    private Integer defensaFisica;

    @Schema(description = "Defensa mágica entidad.", example = "10")
    private Integer defensaMagica;

    // Relación con la tabla ClasePersonaje (One-to-One)
    @OneToOne(mappedBy = "estadisticas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Clase de personaje asociada a estas estadísticas.")
    private ClasePersonaje clasePersonaje;

    // Relación con la tabla Personajes (One-to-One)
    @OneToOne(mappedBy = "estadisticas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Personaje asociado a estas estadísticas.")
    private Personaje personaje;

    // Relación con la tabla Monstruos (One-to-One)
    @OneToOne(mappedBy = "estadisticas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Monstruo asociado a estas estadísticas.")
    private Monstruo monstruo;

    // Relación con la tabla EfectosEstados (One-to-Many)
    @OneToMany(mappedBy = "estadisticas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Lista de efectos o estados asociados a estas estadísticas.")
    private List<EfectoEstado> efectosEstados;

    // Relación con la tabla Equipamiento (One-to-Many)
    @OneToMany(mappedBy = "estadisticas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Lista de equipamientos asociados a estas estadísticas.")
    private List<Equipamiento> equipamientos;

    // Relación con la tabla Habilidades (One-to-Many)
    @OneToMany(mappedBy = "estadisticas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Lista de habilidades asociadas a estas estadísticas.")
    private List<Habilidad> habilidades;
}
