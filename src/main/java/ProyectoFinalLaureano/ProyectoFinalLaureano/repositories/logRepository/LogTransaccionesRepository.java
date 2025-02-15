package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogTransaccionesRepository extends JpaRepository<LogTransacciones,Long> {
    List<LogTransacciones> getBytipoTransaccion(TipoTransaccion tipoTransaccion);
}
