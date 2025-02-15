package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.grupoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoGrupoRepository extends JpaRepository<TipoGrupo,Long> {
}
