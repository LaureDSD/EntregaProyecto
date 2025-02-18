package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.monstruoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidadId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonstruoHabilidadRepository  extends JpaRepository<MonstruoHabilidad, MonstruoHabilidadId> {
    @Query("SELECT mh FROM MonstruoHabilidad mh WHERE mh.monstruo.id = :monstruoId")
    List<MonstruoHabilidad> getByMonstruoId(@Param("monstruoId") Long monstruoId);
}
