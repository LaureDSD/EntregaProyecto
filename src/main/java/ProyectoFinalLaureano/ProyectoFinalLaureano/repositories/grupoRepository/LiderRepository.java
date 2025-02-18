package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.grupoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.LiderGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiderRepository extends JpaRepository<LiderGrupo,Long> {
}
