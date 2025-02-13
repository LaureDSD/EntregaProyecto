package ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "efectos_estados")
@Schema(description = "Entidad que representa un efecto o estado en el sistema")
@Getter
@Setter
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


    @Column(name = "vida_base", nullable = false)
    @Schema(description = "Vida base de la  clase", example = "100")
    private int vida_base;
    @Column(name = "escudo_base", nullable = false)
    @Schema(description = "Escudo base de la  clase", example = "0")
    private int escudo_base;


    @Column(name = "energia_base", nullable = false)
    @Schema(description = "Energía base de la clase", example = "50")
    private int energia_base;
    @Column(name = "mana_base", nullable = false)
    @Schema(description = "Mana base de la clase", example = "50")
    private int emana_base;


    @Column(name = "ataque_fisico_base", nullable = false)
    @Schema(description = "Ataque base de la clase", example = "10")
    private int ataquefiscobase;
    @Column(name = "ataque_magico_base", nullable = false)
    @Schema(description = "Ataque base de la clase", example = "10")
    private int ataqueMagicoBase;


    @Column(name = "defensa_fisica")
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensamagica;
    @Column(name = "defensa_magica")
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensafisica;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del efecto", example = "Aumenta el ataque en 5 puntos")
    private String descripcion;

}
