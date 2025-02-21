package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.Npc;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NpcRepository extends JpaRepository<Npc,Long> {
    List<Npc> getBytipoNPC(TipoNPC tipoNPC);
}
