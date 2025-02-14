package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMisionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeMisionRepository  extends JpaRepository<PersonajeMision, PersonajeMisionId> {
}
