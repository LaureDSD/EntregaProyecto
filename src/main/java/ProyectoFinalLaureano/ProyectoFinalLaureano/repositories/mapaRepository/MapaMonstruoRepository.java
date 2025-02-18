package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapaMonstruoRepository extends JpaRepository<MapaMonstruo, MapaMonstruoId> {
    @Query("SELECT mm FROM MapaMonstruo mm WHERE mm.mapa.id = :mapaId")
    List<MapaMonstruo> getByMapaId(@Param("mapaId") Long mapaId);
}
