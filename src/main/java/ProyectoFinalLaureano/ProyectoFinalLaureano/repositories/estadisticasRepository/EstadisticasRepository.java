package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.estadisticasRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasRepository extends JpaRepository<EstadisticasGenerales,Long> {
}
