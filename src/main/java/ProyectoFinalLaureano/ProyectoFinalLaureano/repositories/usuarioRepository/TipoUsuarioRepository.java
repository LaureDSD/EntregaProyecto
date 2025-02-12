package ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.usuarioRepository;

import ProyectoFinalLaureano.ProyectoFinalLaureano.enums.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Long> {
}
