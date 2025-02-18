package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.habilidadRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.ObjetivoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadRepository  extends JpaRepository<Habilidad,Long> {

    //IA genera una funcion quue obtiene algo de tres campos
    // Búsqueda por tipoHabilidad y objetivoHabilidad
    @Query("SELECT DISTINCT h FROM Habilidad h " +
            "WHERE (:tipoHabilidad IS NULL OR h.tipoHabilidad = :tipoHabilidad) " +
            "AND (:objetivoHabilidad IS NULL OR h.objetivoHabilidad = :objetivoHabilidad)")

    List<Habilidad> buscarPorFiltro(
            @Param("tipoHabilidad") TipoHabilidad tipoHabilidad,
            @Param("objetivoHabilidad") ObjetivoHabilidad objetivoHabilidad
    );

}
