package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.LogrosPersonaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroPersonajeRepository extends JpaRepository<LogrosPersonaje,Long> {
}
