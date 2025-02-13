package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMapaRepository  extends JpaRepository<TipoMapa,Long> {
}
