package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasPersonajeRepository extends JpaRepository<EstadisticasPersonaje,Long> {
}
