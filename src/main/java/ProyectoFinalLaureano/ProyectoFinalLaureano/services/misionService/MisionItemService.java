package ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.MisionItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.misionRepository.MisionObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisionItemService {
    @Autowired
    private MisionObjetoRepository misionObjetoRepository;

    public List<MisionItem> getAll(){
        return  misionObjetoRepository.findAll();
    }

    public MisionItem getByID(Long id){
        return misionObjetoRepository.findById(id).orElse(null);
    }

    public MisionItem setItem(MisionItem o){
        return  misionObjetoRepository.save(o);
    }

    public  void deleteByID(Long id){
        misionObjetoRepository.deleteById(id);
    }

}
