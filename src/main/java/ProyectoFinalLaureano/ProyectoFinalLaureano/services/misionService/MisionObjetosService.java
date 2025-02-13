package ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.MisionObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.MisionObjetoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.misionRepository.MisionObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisionObjetosService {
    @Autowired
    private MisionObjetoRepository misionObjetoRepository;

    public List<MisionObjetos> getAll(){
        return  misionObjetoRepository.findAll();
    }

    public MisionObjetos getByID(MisionObjetoId id){
        return misionObjetoRepository.findById(id).orElse(null);
    }

    public MisionObjetos setItem(MisionObjetos o){
        return  misionObjetoRepository.save(o);
    }

    public  void deleteByID(MisionObjetoId id){
        misionObjetoRepository.deleteById(id);
    }
}
