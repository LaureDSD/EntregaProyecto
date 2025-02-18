package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.monstruoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidadId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonstruoHabilidadRepository  extends JpaRepository<MonstruoHabilidad, MonstruoHabilidadId> {

}
