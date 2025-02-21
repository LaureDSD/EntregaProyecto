package ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.monstruoRepository.MonstruoHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonstruoHabilidadService {

    @Autowired
    private MonstruoHabilidadRepository monstruoHabilidadRepository;

    public List<MonstruoHabilidad> getAll(){
        return  monstruoHabilidadRepository.findAll();
    }

    public MonstruoHabilidad getByID(Long id){
        return monstruoHabilidadRepository.findById(id).orElse(null);
    }

    public MonstruoHabilidad setItem(MonstruoHabilidad o){
        return  monstruoHabilidadRepository.save(o);
    }

    public  void deleteByID(Long id){
        monstruoHabilidadRepository.deleteById(id);
    }

}
