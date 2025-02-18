package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMisionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeMisionRepository  extends JpaRepository<PersonajeMision, PersonajeMisionId> {
    @Query("SELECT ph FROM PersonajeMision ph WHERE ph.id.personaje_id = :personajeId")
    List<PersonajeMision> getByPersonajeId(@Param("personajeId") Long personajeId);
}
