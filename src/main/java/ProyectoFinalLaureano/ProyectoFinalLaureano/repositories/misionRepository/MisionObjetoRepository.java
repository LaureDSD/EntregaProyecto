package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.misionRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.MisionObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.MisionObjetoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MisionObjetoRepository extends JpaRepository<MisionObjetos, MisionObjetoId> {
}
