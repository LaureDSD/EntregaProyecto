package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaMonstruo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapaMonstruoRepository extends JpaRepository<MapaMonstruo, Long> {

}
