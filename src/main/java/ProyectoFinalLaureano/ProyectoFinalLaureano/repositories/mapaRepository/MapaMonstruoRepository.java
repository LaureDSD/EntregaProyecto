package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapaMonstruoRepository extends JpaRepository<MapaMonstruo, MapaMonstruoId> {
}
