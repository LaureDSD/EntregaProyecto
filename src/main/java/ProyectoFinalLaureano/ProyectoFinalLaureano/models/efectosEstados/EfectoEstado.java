package ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados;

import ProyectoFinalLaureano.ProyectoFinalLaureano.enums.TipoAfectado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.enums.TipoEfecto;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "efectos_estados")
@Schema(description = "Entidad que representa un efecto o estado en el sistema")
public class EfectoEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del efecto", example = "1")
    private Long efecto_id;

    @Column(name = "imagen_icono", length = 255)
    @Schema(description = "URL del icono del efecto", example = "potenciacion.png")
    private String imagen_icono;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del efecto", example = "Fuerza")
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    @Schema(description = "Tipo de efecto (buff, debuff)", example = "buff")
    private TipoEfecto tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_afectado", nullable = false)
    @Schema(description = "Tipo de entidad afectada (personaje, monstruo, todo)", example = "personaje")
    private TipoAfectado tipo_afectado;

    @Column(name = "duracion_efecto", nullable = false)
    @Schema(description = "Duración del efecto en turnos", example = "5")
    private int duracion_efecto;

    @Column(name = "intervalos_efecto", nullable = false)
    @Schema(description = "Intervalos de aplicación del efecto", example = "1")
    private int intervalos_efecto;

    @Column(name = "acumulaciones", nullable = false)
    @Schema(description = "Número de acumulaciones del efecto", example = "0")
    private int acumulaciones;

    @Column(name = "ataque")
    @Schema(description = "Modificador de ataque del efecto", example = "5")
    private int ataque;

    @Column(name = "defensa")
    @Schema(description = "Modificador de defensa del efecto", example = "0")
    private int defensa;

    @Column(name = "vida")
    @Schema(description = "Modificador de vida del efecto", example = "0")
    private int vida;

    @Column(name = "energia")
    @Schema(description = "Modificador de energía del efecto", example = "0")
    private int energia;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del efecto", example = "Aumenta el ataque en 5 puntos")
    private String descripcion;

}
