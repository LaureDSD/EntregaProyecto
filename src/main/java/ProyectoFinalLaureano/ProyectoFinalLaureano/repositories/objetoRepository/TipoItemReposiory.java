package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.objetoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoItemReposiory extends JpaRepository<TipoItem,Long> {
}
