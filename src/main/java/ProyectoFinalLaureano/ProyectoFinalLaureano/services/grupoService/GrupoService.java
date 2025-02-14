package ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.grupoRepository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> getAll(){
        return  grupoRepository.findAll();
    }

    public Grupo getByID(Long id){
        return grupoRepository.findById(id).orElse(null);
    }

    public Grupo setItem(Grupo o){
        return  grupoRepository.save(o);
    }

    public  void deleteByID(Long id){
        grupoRepository.deleteById(id);
    }
}
