package ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.misionRepository.MisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisionService {
    @Autowired
    private MisionRepository misionRepository;

    public List<Mision> getAll(){
        return  misionRepository.findAll();
    }

    public Mision getByID(Long id){
        return misionRepository.findById(id).orElse(null);
    }

    public Mision setItem(Mision o){
        return  misionRepository.save(o);
    }

    public  void deleteByID(Long id){
        misionRepository.deleteById(id);
    }
}
