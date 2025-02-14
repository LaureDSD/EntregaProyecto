package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.grupoRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Gremio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GremioRepository extends JpaRepository<Gremio, Long> {
}
