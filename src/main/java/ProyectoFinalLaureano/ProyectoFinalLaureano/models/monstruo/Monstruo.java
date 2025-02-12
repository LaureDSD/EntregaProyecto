package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "monstruos")
@Schema(description = "Entidad que representa un monstruo en el sistema")
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del monstruo", example = "1")
    private Long monstruo_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del monstruo", example = "Goblin")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "tipo_monstruo_id", nullable = false)
    @Schema(description = "Tipo de monstruo (relación con la tabla tipo_monstruo)")
    private TipoMonstruo tipo_monstruo;

    @Column(name = "nivel")
    @Schema(description = "Nivel del monstruo", example = "1")
    private int nivel;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del monstruo", example = "Un pequeño monstruo verde")
    private String descripcion;

    @Column(name = "imagen", length = 255)
    @Schema(description = "URL de la imagen del monstruo", example = "goblin.jpg")
    private String imagen;

    @Column(name = "vida_maxima", nullable = false)
    @Schema(description = "Vida máxima del monstruo", example = "50")
    private int vida_maxima;

    @Column(name = "energia_maxima", nullable = false)
    @Schema(description = "Energía máxima del monstruo", example = "20")
    private int energia_maxima;

    @Column(name = "ataque_base", nullable = false)
    @Schema(description = "Ataque base del monstruo", example = "5")
    private int ataque_base;

    @Column(name = "defensa", nullable = false)
    @Schema(description = "Defensa del monstruo", example = "2")
    private int defensa;

    @Column(name = "almas", nullable = false)
    @Schema(description = "Almas que otorga el monstruo al ser derrotado", example = "10")
    private int almas;

    @Column(name = "experiencia_otorgada")
    @Schema(description = "Experiencia que otorga el monstruo al ser derrotado", example = "5")
    private int experiencia_otorgada;

    // Relación Muchos a Muchos con Habilidad
    @ManyToMany(mappedBy = "monstruos")
    private List<Habilidad> habilidades = new ArrayList<>();

    // Relación Muchos a Muchos con Mapa
    @ManyToMany
    @JoinTable(
            name = "mapa_monstruos",
            joinColumns = @JoinColumn(name = "monstruo_id"),
            inverseJoinColumns = @JoinColumn(name = "mapa_id")
    )
    private List<Mapa> mapas = new ArrayList<>();

    // Relación Uno a Muchos con DropsObjetos
    @OneToMany(mappedBy = "monstruo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DropsObjetos> drops = new ArrayList<>();


}