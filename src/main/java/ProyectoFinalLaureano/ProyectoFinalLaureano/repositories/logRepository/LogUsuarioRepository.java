package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogUsuarioRepository extends JpaRepository<LogUsuario,Long> {
    List<LogUsuario> getBytipoLog(TipoLog tipoLog);
}
