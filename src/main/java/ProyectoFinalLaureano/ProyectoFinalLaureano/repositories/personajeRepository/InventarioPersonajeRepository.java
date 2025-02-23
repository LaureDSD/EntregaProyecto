package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioPersonajeRepository extends JpaRepository<PersonajeItem, Long> {

}
