package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.itemRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.TipoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> getBytipoItem(TipoItem tipoItem);
}
