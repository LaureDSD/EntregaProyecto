package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoanjeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<Personaje> getAll(){
        return  personajeRepository.findAll();
    }

    public Personaje getByID(Long id){
        return personajeRepository.findById(id).orElse(null);
    }

    public Personaje setItem(Personaje o){
        return  personajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        personajeRepository.deleteById(id);
    }
}
