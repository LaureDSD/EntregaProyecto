package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTransaccionesRepository extends JpaRepository<LogTransacciones,Long> {
}
