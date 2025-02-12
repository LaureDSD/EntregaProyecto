package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "misiones")
@Schema(description = "Entidad que representa una misión en el sistema")
public class Mision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la misión", example = "1")
    private Long mision_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre de la misión", example = "Cazar Goblin")
    private String nombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    @Schema(description = "Descripción de la misión", example = "Derrota a 5 Goblins")
    private String descripcion;

    @Column(name = "nivel_minimo", nullable = false)
    @Schema(description = "Nivel mínimo requerido para la misión", example = "1")
    private int nivel_minimo;

    @Column(name = "recompensa_almas")
    @Schema(description = "Almas otorgadas como recompensa", example = "50")
    private int recompensa_almas;

    @Column(name = "recompensa_experiencia")
    @Schema(description = "Experiencia otorgada como recompensa", example = "100")
    private int recompensa_experiencia;

    @Column(name = "fecha_limite")
    @Schema(description = "Fecha límite para completar la misión", example = "30")
    private int fecha_limite;

    @OneToMany(mappedBy = "mision", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PersonajeMision> personajes = new ArrayList<>();

    // Relación Muchos a Muchos con NPC
    @ManyToMany
    @JoinTable(
            name = "npc_mision",
            joinColumns = @JoinColumn(name = "mision_id"),
            inverseJoinColumns = @JoinColumn(name = "npc_id")
    )
    private List<NPC> npcs = new ArrayList<>();

    // Relación Uno a Muchos con MisionObjetos
    @OneToMany(mappedBy = "mision", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MisionObjetos> recompensas = new ArrayList<>();


}
