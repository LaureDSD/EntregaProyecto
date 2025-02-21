package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface LogPesonajeMonstruoRepository extends JpaRepository<LogPersonajeMonstruo,Long> {

}
