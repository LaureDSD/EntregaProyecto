package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.EstadisticasPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasPersonajeService {

    @Autowired
    EstadisticasPersonajeRepository estadisticasPersonajeRepository;

    public List<EstadisticasPersonaje> getAll(){
        return  estadisticasPersonajeRepository.findAll();
    }

    public EstadisticasPersonaje getByID(Long id){
        return estadisticasPersonajeRepository.findById(id).orElse(null);
    }

    public EstadisticasPersonaje setItem(EstadisticasPersonaje o){
        return  estadisticasPersonajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        estadisticasPersonajeRepository.deleteById(id);
    }
}
