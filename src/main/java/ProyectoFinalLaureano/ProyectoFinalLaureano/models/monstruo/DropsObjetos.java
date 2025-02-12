package ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class DropsObjetos {

    @ManyToOne
    @JoinColumn(name = "monstruo_id", nullable = false)
    private Monstruo monstruo;

    // Relación Muchos a Uno con Item
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

}
