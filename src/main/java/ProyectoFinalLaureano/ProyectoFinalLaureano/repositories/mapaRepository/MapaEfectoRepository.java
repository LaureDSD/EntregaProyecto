package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaEfectoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapaEfectoRepository  extends JpaRepository<MapaEfecto, MapaEfectoId> {
}
