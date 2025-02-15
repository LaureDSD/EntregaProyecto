package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.objetoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.equipamiento.TipoEquipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEquipamientoRepository extends JpaRepository<TipoEquipamiento,Long> {
}
