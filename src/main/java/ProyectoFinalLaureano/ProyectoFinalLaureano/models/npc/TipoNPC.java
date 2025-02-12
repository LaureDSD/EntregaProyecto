package ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "tipo_npc")
@Schema(description = "Entidad que representa un tipo de NPC en el sistema")
@Getter
@Setter
public class TipoNPC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del tipo de NPC", example = "1")
    private Long tipo_npc_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del tipo de NPC", example = "Aldeano")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del tipo de NPC", example = "Un aldeano común que ofrece misiones simples")
    private String descripcion;

    // Relación Uno a Muchos con NPC
    @OneToMany(mappedBy = "tipo_npc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "NPCs asociados a este tipo")
    private List<NPC> npcs;
}