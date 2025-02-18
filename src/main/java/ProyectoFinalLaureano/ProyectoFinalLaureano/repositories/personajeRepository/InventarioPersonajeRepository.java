package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonajeId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioPersonajeRepository extends JpaRepository<InventarioPersonaje, InventarioPersonajeId> {
    @Query("SELECT ip FROM InventarioPersonaje ip WHERE ip.personaje.personaje_id = :personajeId")
    List<InventarioPersonaje> getByPersonajeId(@Param("personajeId") Long personajeId);
}
