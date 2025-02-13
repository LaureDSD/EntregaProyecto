package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.misionRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MisionRepository  extends JpaRepository<Mision,Long> {
}
