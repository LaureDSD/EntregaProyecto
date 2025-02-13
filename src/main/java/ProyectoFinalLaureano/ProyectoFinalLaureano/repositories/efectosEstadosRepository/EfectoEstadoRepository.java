package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.efectosEstadosRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfectoEstadoRepository  extends JpaRepository<EfectoEstado,Long> {
}
