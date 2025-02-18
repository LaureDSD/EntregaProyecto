package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.habilidadRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfectoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadEfectoRepository extends JpaRepository<HabilidadEfecto, HabilidadEfectoId> {
    @Query("SELECT he.efecto FROM HabilidadEfecto he WHERE he.habilidad.habilidadId = :habilidadId")
    List<EfectoEstado> findByHabilidadId(@Param("habilidadId") Long habilidadId);
}
