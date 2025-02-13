package ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.habilidadRepository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadService {
    @Autowired
    private HabilidadRepository habilidadRepository;

    public List<Habilidad> getAll(){
        return  habilidadRepository.findAll();
    }

    public Habilidad getByID(Long id){
        return habilidadRepository.findById(id).orElse(null);
    }

    public Habilidad setItem(Habilidad o){
        return  habilidadRepository.save(o);
    }

    public  void deleteByID(Long id){
        habilidadRepository.deleteById(id);
    }
}
