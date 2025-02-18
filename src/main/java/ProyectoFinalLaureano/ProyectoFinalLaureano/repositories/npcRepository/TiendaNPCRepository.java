package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProducto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProductoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiendaNPCRepository extends JpaRepository<NPCProducto, NPCProductoId> {

    List<NPCProducto> findByNpcId(Long npcId);
}
