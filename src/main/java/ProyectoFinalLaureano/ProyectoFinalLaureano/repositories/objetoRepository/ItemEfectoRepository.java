package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.objetoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfectoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEfectoRepository extends JpaRepository<ItemEfecto, ItemEfectoId> {
}
