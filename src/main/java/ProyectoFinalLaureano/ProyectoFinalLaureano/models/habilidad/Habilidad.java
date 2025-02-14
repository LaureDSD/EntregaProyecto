package ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfecto;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la habilidad", example = "1")
    private Long habilidad_id;

    @Column(name = "imagen", length = 255)
    @Schema(description = "URL de la imagen de la habilidad", example = "habilidad1.png")
    private String imagen;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre de la habilidad", example = "Corte rápido")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción de la habilidad", example = "Un ataque rápido con la espada")
    private String descripcion;

    @Column(name = "nivel_maximo", nullable = false)
    @Schema(description = "Nivel máximo de la habilidad", example = "5")
    private int nivel_maximo;

    @Column(name = "requisito_nivel", nullable = false)
    @Schema(description = "Nivel requerido para aprender la habilidad", example = "1")
    private int requisito_nivel;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_habilidad", nullable = false)
    @Schema(description = "Tipo de habilidad (ofensiva, defensiva, apoyo)", example = "ofensiva")
    private TipoHabilidad tipo_habilidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "objetivo_habilidad", nullable = false)
    @Schema(description = "Objetivo de la habilidad (jugador, aliado, enemigo, todo)", example = "enemigo")
    private ObjetivoHabilidad objetivo_habilidad;

    @Column(name = "area_efecto", nullable = false)
    @Schema(description = "Área de efecto de la habilidad", example = "1")
    private int area_efecto;

    @Column(name = "unidades_afectadas", nullable = false)
    @Schema(description = "Número de unidades afectadas por la habilidad", example = "1")
    private int unidades_afectadas;


    @Column(name = "vida_base", nullable = false)
    @Schema(description = "Vida base del monstruo", example = "100")
    private int vida_base;
    @Column(name = "escudo_base", nullable = false)
    @Schema(description = "Escudo base del monstruo", example = "0")
    private int escudo_base;


    @Column(name = "energia_base", nullable = false)
    @Schema(description = "Energía base del monstruo", example = "50")
    private int energia_base;
    @Column(name = "mana_base", nullable = false)
    @Schema(description = "Mana base del monstruo", example = "50")
    private int emana_base;


    @Column(name = "ataque_fisico_base", nullable = false)
    @Schema(description = "Ataque base del monstruo", example = "10")
    private int ataquefiscobase;
    @Column(name = "ataque_magico_base", nullable = false)
    @Schema(description = "Ataque base del persoanje", example = "10")
    private int ataqueMagicoBase;

    @Column(name = "defensa_fisica")
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensamagica;
    @Column(name = "defensa_magica")
    @Schema(description = "Defensa de la clase", example = "5")
    private int defensafisica;


    @Column(name = "enfriamiento", nullable = false)
    @Schema(description = "Tiempo de enfriamiento de la habilidad", example = "2")
    private int enfriamiento;

    // Relación Uno a Muchos con HabilidadEfecto
    @OneToMany(mappedBy = "habilidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Efectos asociados a la habilidad")
    private List<HabilidadEfecto> efectos;

    //Nuevo
    @OneToMany(mappedBy = "habilidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Monstruos que poseen esta habilidad")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<MonstruoHabilidad> monstruoHabilidades;

    @OneToMany(mappedBy = "habilidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Personajes que poseen esta habilidad")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<PersonajeHabilidad> personajeHabilidades;
}
