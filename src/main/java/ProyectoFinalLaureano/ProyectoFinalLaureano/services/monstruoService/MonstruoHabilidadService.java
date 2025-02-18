package ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidadId;
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

    public MonstruoHabilidad getByID(MonstruoHabilidadId id){
        return monstruoHabilidadRepository.findById(id).orElse(null);
    }

    public MonstruoHabilidad setItem(MonstruoHabilidad o){
        return  monstruoHabilidadRepository.save(o);
    }

    public  void deleteByID(MonstruoHabilidadId id){
        monstruoHabilidadRepository.deleteById(id);
    }


}
