package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.itemRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.ItemEfecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemEfectoRepository extends JpaRepository<ItemEfecto, Long> {

}
