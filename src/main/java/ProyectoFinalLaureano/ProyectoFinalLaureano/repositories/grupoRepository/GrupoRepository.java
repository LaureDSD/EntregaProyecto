package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.grupoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo,Long> {
    List<Grupo> getBytipoGrupo(TipoGrupo tg);
}
