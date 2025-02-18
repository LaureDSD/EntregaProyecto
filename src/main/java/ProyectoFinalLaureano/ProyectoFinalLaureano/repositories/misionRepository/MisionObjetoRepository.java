package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.misionRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.recompensas.MisionObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.recompensas.MisionObjetoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MisionObjetoRepository extends JpaRepository<MisionObjetos, MisionObjetoId> {
    @Query("SELECT mo FROM MisionObjetos mo WHERE mo.mision.id = :misionId")
    List<MisionObjetos> getByMisionId(@Param("misionId") Long misionId);
}
