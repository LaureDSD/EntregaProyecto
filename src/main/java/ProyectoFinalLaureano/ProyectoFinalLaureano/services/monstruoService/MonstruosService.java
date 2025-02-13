package ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.monstruoRepository.MonstruoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonstruosService {
    @Autowired
    private MonstruoRepository monstruoRepository;

    public List<Monstruo> getAll(){
        return  monstruoRepository.findAll();
    }

    public Monstruo getByID(Long id){
        return monstruoRepository.findById(id).orElse(null);
    }

    public Monstruo setItem(Monstruo o){
        return  monstruoRepository.save(o);
    }

    public  void deleteByID(Long id){
        monstruoRepository.deleteById(id);
    }
}
