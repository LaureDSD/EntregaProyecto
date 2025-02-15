package ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.ObjetivoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidad;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "habilidades")
@Schema(description = "Entidad que representa una habilidad en el sistema")
@Getter
@Setter
public class Habilidad {

    //ID de habilidad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la habilidad", example = "1")
    private Long habilidad_id;

    //Imagen de la habilidad
    @Column(name = "imagen", length = 255)
    @Schema(description = "URL de la imagen de la habilidad", example = "habilidad1.png")
    private String imagen;

    //nombre de la habilidad
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre de la habilidad", example = "Corte rápido")
    private String nombre;

    //Descripcion de la haibilidad
    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción de la habilidad", example = "Un ataque rápido con la espada")
    private String descripcion;

    //Nivel maximo de la habilidad
    @Column(name = "nivel_maximo", nullable = false)
    @Schema(description = "Nivel máximo de la habilidad", example = "5")
    private int nivel_maximo;

    //Rquisito de nivel
    @Column(name = "requisito_nivel", nullable = false)
    @Schema(description = "Nivel requerido para aprender la habilidad", example = "1")
    private int requisito_nivel;

    //Tipo de habbilidad
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_habilidad", nullable = false)
    @Schema(description = "Tipo de habilidad (ofensiva, defensiva, apoyo)", example = "ofensiva")
    private TipoHabilidad tipoHabilidad;

    //Objetivo de habilidad
    @Enumerated(EnumType.STRING)
    @Column(name = "objetivo_habilidad", nullable = false)
    @Schema(description = "Objetivo de la habilidad (jugador, aliado, enemigo, todo)", example = "enemigo")
    private ObjetivoHabilidad objetivoHabilidad;

    //Area de efecto
    @Column(name = "area_efecto", nullable = false)
    @Schema(description = "Área de efecto de la habilidad", example = "1")
    private double area_efecto;

    //Limite de unidades afectadas
    @Column(name = "unidades_afectadas", nullable = false)
    @Schema(description = "Número de unidades afectadas por la habilidad", example = "1")
    private int unidades_afectadas;

    //RelacionCon Estadisticas
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadisticas_id", referencedColumnName = "estadisticasId")
    private EstadisticasGenerales estadisticas;

    //Enfriamiento de la habilidad
    @Column(name = "enfriamiento", nullable = false)
    @Schema(description = "Tiempo de enfriamiento de la habilidad", example = "2")
    private int enfriamiento;

    // Relación con HabilidadEfecto 1:N
    @OneToMany(mappedBy = "habilidad", cascade = CascadeType.ALL)
    @Schema(description = "Efectos asociados a la habilidad")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<HabilidadEfecto> efectos;

    //Relacion con monstruos 1:N
    @OneToMany(mappedBy = "habilidad", cascade = CascadeType.ALL)
    @Schema(description = "Monstruos que poseen esta habilidad")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<MonstruoHabilidad> monstruoHabilidades;

    //Relacion con habilidad 1:N
    @OneToMany(mappedBy = "habilidad", cascade = CascadeType.ALL)
    @Schema(description = "Personajes que poseen esta habilidad")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<PersonajeHabilidad> personajeHabilidades;
}
