package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.misionRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.PersonajeMisionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeMisionRepository  extends JpaRepository<PersonajeMision, PersonajeMisionId> {
}
