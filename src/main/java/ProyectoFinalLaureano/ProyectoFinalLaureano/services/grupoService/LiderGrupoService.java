package ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.LiderGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.grupoRepository.LiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiderGrupoService {

    @Autowired
    private LiderRepository liderGrupoRepository;

    public List<LiderGrupo> findAll() {
        return liderGrupoRepository.findAll();
    }

    public Optional<LiderGrupo> findById(Long id) {
        return liderGrupoRepository.findById(id);
    }

    public LiderGrupo save(LiderGrupo liderGrupo) {
        return liderGrupoRepository.save(liderGrupo);
    }

    public void deleteById(Long id) {
        liderGrupoRepository.deleteById(id);
    }
}
