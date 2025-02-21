package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NpcItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcItemRepository extends JpaRepository<NpcItem, Long> {

}
