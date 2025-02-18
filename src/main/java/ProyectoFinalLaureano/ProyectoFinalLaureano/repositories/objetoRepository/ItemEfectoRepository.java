package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.objetoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfectoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemEfectoRepository extends JpaRepository<ItemEfecto, ItemEfectoId> {
    @Query("SELECT ie FROM ItemEfecto ie WHERE ie.item.item_id = :itemId")
    List<ItemEfecto> getByItemId(@Param("itemId") Long itemId);
}
