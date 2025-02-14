package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProducto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProductoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaNPCRepository extends JpaRepository<NPCProducto, NPCProductoId> {
}
