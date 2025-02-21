package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.efectosEstadosRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EfectoEstadoRepository  extends JpaRepository<EfectoEstado,Long> {

}
