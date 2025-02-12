package ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "npc")
@Schema(description = "Entidad que representa un NPC en el sistema")
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
    @Schema(description = "Tipo de NPC (relación con la tabla tipo_npc)")
    private TipoNPC tipo_npc;

    // Relación Muchos a Muchos con Mision
    @ManyToMany(mappedBy = "npcs")
    private List<Mision> misiones = new ArrayList<>();

    // Relación Uno a Muchos con TransaccionesNPC
    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransaccionesNPC> transacciones = new ArrayList<>();

}