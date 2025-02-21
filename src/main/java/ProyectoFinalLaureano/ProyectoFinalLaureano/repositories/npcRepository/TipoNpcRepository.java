package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoNpcRepository extends JpaRepository<TipoNPC,Long> {
}
