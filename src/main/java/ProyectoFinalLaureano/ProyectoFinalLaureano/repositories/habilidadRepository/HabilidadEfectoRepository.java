package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.habilidadRepository;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.HabilidadEfecto;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface HabilidadEfectoRepository extends JpaRepository<HabilidadEfecto, Long> {

}
