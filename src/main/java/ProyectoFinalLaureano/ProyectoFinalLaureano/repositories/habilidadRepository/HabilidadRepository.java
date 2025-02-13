package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.habilidadRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository  extends JpaRepository<Habilidad,Long> {
}
