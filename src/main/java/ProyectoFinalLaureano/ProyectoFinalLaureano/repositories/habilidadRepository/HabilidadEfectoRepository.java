package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.habilidadRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfectoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadEfectoRepository extends JpaRepository<HabilidadEfecto, HabilidadEfectoId> {
}
