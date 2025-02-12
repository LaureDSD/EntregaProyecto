package ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import jakarta.persistence.*;

@Entity
@Table(name = "transacciones_npc_personaje")
public class TransaccionesNPC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaccion_id;

    // Relación Muchos a Uno con Personaje
    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = false)
    private Personaje personaje;

    // Relación Muchos a Uno con NPC
    @ManyToOne
    @JoinColumn(name = "npc_id", nullable = false)
    private NPC npc;

    // Relación Muchos a Uno con Item
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

}
