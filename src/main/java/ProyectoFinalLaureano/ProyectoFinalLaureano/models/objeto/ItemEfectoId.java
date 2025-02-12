package ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ItemEfectoId implements Serializable {
    private Long item_id;
    private Long efecto_id;
}
