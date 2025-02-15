package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersoanjeMonstruo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogPesonajeRepository extends JpaRepository<LogPersoanjeMonstruo,Long> {
}
