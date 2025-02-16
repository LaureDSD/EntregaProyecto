package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.ClasePersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.ClasePersoanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasePersonajeService {

    @Autowired
    ClasePersoanjeRepository clasePersoanjeRepository;

    public List<ClasePersonaje> getAll(){
        return  clasePersoanjeRepository.findAll();
    }

    public ClasePersonaje getByID(Long id){
        return clasePersoanjeRepository.findById(id).orElse(null);
    }

    public ClasePersonaje setItem(ClasePersonaje o){
        return  clasePersoanjeRepository.save(o);
    }

    public  void deleteByID(Long id){
        clasePersoanjeRepository.deleteById(id);
    }
}
