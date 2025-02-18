package ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProducto;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

// ( Correcto )
@NoArgsConstructor
@Entity
@Table(name = "npc")
@Schema(description = "Entidad que representa un NPC en el sistema")
@Getter
@Setter
public class NPC {

    // ID del npc
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del NPC", example = "1")
    private Long id;

    // Nombre del npc
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del NPC", example = "Aldeano")
    private String nombre;

    //Desdcripcion del npc
    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Schema(description = "Descripción del NPC", example = "Un aldeano común que ofrece misiones simples")
    private String descripcion;

    //Imagen del npc
    @Column(name = "imagen", length = 255)
    @Schema(description = "URL de la imagen del NPC", example = "aldeano.jpg")
    private String imagen;

    // Relacion con el tipo npc N:1
    @ManyToOne
    @JoinColumn(name = "tipo_npc", nullable = false)
    @Schema(description = "Tipo de NPC asociado")
    private TipoNPC tipoNPC;

    // Relación  con TransaccionesNPC 1:N
    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL)
    @Schema(description = "Transacciones asociadas a este NPC")
    @JsonIgnore // Excluir esta relación en la serialización JSON
    private List<LogTransacciones> transacciones;

    //Relacion con los productos que vende 1:N
    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL)
    @Schema(description = "Productos asociados a este NPC")
    @JsonIgnore // Excluir esta relación en la serialización JSON
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