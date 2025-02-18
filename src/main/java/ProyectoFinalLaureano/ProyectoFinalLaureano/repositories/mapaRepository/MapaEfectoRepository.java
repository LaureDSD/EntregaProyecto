package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfectoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapaEfectoRepository  extends JpaRepository<MapaEfecto, MapaEfectoId> {
    @Query("SELECT me FROM MapaEfecto me WHERE me.mapa.id = :mapaId")
    List<MapaEfecto> getByMapaId(@Param("mapaId") Long mapaId);
}
