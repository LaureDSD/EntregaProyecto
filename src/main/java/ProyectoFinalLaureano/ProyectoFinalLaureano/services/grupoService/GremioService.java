package ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Gremio;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.grupoRepository.GremioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GremioService {

    @Autowired
    private GremioRepository gremioRepository;

    public List<Gremio> getAll(){
        return  gremioRepository.findAll();
    }

    public Gremio getByID(Long id){
        return gremioRepository.findById(id).orElse(null);
    }

    public Gremio setItem(Gremio o){
        return  gremioRepository.save(o);
    }

    public  void deleteByID(Long id){
        gremioRepository.deleteById(id);
    }
}
