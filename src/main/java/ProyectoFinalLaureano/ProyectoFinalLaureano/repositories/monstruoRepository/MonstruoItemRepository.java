package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.monstruoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonstruoItemRepository extends JpaRepository<MonstruoItem, Long> {
}
