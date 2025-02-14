package ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProducto;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "npc")
@Schema(description = "Entidad que representa un NPC en el sistema")
@Getter
@Setter
public class NPC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del NPC", example = "1")
    private Long npc_id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del NPC", example = "Aldeano")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del NPC", example = "Un aldeano común que ofrece misiones simples")
    private String descripcion;

    @Column(name = "imagen", length = 255)
    @Schema(description = "URL de la imagen del NPC", example = "aldeano.jpg")
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "tipo_npc", nullable = false)
    @Schema(description = "Tipo de NPC asociado")
    private TipoNPC tipo_npc;

    // Relación Uno a Muchos con TransaccionesNPC
    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Transacciones asociadas a este NPC")
    private List<LogTransacciones> transacciones;

    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Productos asociados a este NPC")
    private List<NPCProducto> npcProductos;

    //Relacion muchos a muchos con mision
    @ManyToMany
    @JoinTable(
            name = "npc_mision",
            joinColumns = @JoinColumn(name = "npc_id"),
            inverseJoinColumns = @JoinColumn(name = "mision_id")
    )
    @JsonIgnore // Excluir esta relación en la serialización JSON
    @Schema(description = "Misiones  que da cada npc")
    private List<Mision> misiones;

}