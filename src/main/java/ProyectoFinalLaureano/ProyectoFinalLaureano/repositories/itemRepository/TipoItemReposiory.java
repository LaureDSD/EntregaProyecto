package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.itemRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.TipoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoItemReposiory extends JpaRepository<TipoItem,Long> {
}
