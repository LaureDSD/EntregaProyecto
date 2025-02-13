package ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.monstruoRepository.TipoMonstruoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMonstruoService {
    @Autowired
    private TipoMonstruoRepository tipoMonstruoRepository;

    public List<TipoMonstruo> getAll(){
        return  tipoMonstruoRepository.findAll();
    }

    public TipoMonstruo getByID(Long id){
        return tipoMonstruoRepository.findById(id).orElse(null);
    }

    public TipoMonstruo setItem(TipoMonstruo o){
        return  tipoMonstruoRepository.save(o);
    }

    public  void deleteByID(Long id){
        tipoMonstruoRepository.deleteById(id);
    }
}
