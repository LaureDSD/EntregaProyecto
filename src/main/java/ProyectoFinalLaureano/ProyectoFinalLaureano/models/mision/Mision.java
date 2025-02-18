package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.recompensas.MisionObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMision;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.List;
@NoArgsConstructor
@Entity
@Table(name = "misiones")
@Schema(description = "Entidad que representa una misión en el sistema")
@Getter
@Setter
public class Mision {

    //ID de la mision
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la misión", example = "1")
    private Long misionId;

    //Nombre de la mision
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre de la misión", example = "Cazar Goblin")
    private String nombre;

    //Descripcion de la mision
    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    @Schema(description = "Descripción de la misión", example = "Derrota a 5 Goblins")
    private String descripcion;

    //Nivel minimo para aceptarla
    @Column(name = "nivel_minimo", nullable = false)
    @Schema(description = "Nivel mínimo requerido para la misión", example = "1")
    private int nivel_minimo;

    //recompensa de almas
    @Column(name = "recompensa_almas")
    @Schema(description = "Almas otorgadas como recompensa", example = "50")
    private int recompensa_almas;

    //Recompensa de experiencia
    @Column(name = "recompensa_experiencia")
    @Schema(description = "Experiencia otorgada como recompensa", example = "100")
    private int recompensa_experiencia;

    //Limite de tiempo
    @Column(name = "tiempo_limite")
    @Schema(description = "Fecha límite para completar la misión", example = "30")
    private int tiempo_limite; //Minutos

    // Relación con PersonajeMision 1:N
    @OneToMany(mappedBy = "mision", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Personajes asociados a esta misión")
    private List<PersonajeMision> personajes;

    // Relación con MisionObjeto 1:N
    @OneToMany(mappedBy = "mision", cascade = CascadeType.ALL)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Objetos de recompensa asociados a esta misión")
    private List<MisionObjetos> recompensas;


    //Relacion muchos a muchos con npc
    @ManyToMany
    @JoinTable(
            name = "npc_mision",
            joinColumns = @JoinColumn(name = "misionId"),
            inverseJoinColumns = @JoinColumn(name = "npcId")
    )
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Misiones  que da cada npc")
    private List<NPC> npcs;

}
