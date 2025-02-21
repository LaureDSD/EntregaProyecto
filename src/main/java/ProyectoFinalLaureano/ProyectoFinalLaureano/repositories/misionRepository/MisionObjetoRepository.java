package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.misionRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.MisionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MisionObjetoRepository extends JpaRepository<MisionItem, Long> {

}
