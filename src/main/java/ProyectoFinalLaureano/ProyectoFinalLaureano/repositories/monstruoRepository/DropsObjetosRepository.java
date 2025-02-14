package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.monstruoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.drops.DropsObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.drops.DropsObjetosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DropsObjetosRepository extends JpaRepository<DropsObjetos, DropsObjetosId> {
}
