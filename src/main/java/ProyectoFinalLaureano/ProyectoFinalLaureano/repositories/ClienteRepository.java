package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories;

import ad.RepasoExamen.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente getByUsuario(String usuario);
}
