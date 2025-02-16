package ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.enums.TipoAfectado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.enums.TipoEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// (Correcto)
@NoArgsConstructor
@Entity
@Table(name = "efectos_estados")
@Schema(description = "Entidad que representa un efecto o estado en el sistema")
@Getter
@Setter
public class EfectoEstado {

    //ID del efecto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del efecto", example = "1")
    private Long efecto_id;

    //Imagen del efecto
    @Column(name = "imagen_icono", length = 255)
    @Schema(description = "URL del icono del efecto", example = "potenciacion.png")
    private String imagen_icono;

    //Nomber del efecto
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del efecto", example = "Fuerza")
    private String nombre;

    //Descripcion del efecto
    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del efecto", example = "Aumenta el ataque en 5 puntos")
    private String descripcion;

    //Tipo de efecto
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    @Schema(description = "Tipo de efecto (buff, debuff)", example = "buff")
    private TipoEfecto tipo;

    //Tipo de objetivo afectado
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_afectado", nullable = false)
    @Schema(description = "Tipo de entidad afectada (personaje, monstruo, todo)", example = "personaje")
    private TipoAfectado tipo_afectado;

    //Duracion del efecto
    @Column(name = "duracion_efecto", nullable = false)
    @Schema(description = "Duración del efecto en turnos", example = "5")
    private double duracion_efecto;

    //Intervalos de efecto
    @Column(name = "intervalos_efecto", nullable = false)
    @Schema(description = "Intervalos de aplicación del efecto", example = "1")
    private double intervalos_efecto;

    //Vezes que se acumula
    @Column(name = "acumulaciones", nullable = false)
    @Schema(description = "Número de acumulaciones del efecto", example = "0")
    private int acumulaciones;

    //RelacionCon Estadisticas
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadisticas_id", referencedColumnName = "estadisticasId")
    private EstadisticasGenerales estadisticas;

}
