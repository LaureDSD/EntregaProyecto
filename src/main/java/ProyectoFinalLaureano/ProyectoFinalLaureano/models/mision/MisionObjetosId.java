package ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MisionObjetosId implements Serializable {

    private Long mision_id;
    private Long item_id;

}