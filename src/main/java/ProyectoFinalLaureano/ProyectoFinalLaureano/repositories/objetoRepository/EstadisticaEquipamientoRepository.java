package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.objetoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.equipamiento.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaEquipamientoRepository extends JpaRepository<Equipamiento,Long> {
}
