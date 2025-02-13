package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.RegistroPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.RegistroPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroPersonajeService {
    @Autowired
    private RegistroPersonajeRepository registroPersonajeRepository;

    public List<RegistroPersonaje> getAll(){
        return  registroPersonajeRepository.findAll();
    }

    public RegistroPersonaje getByID(Long id){
        return registroPersonajeRepository.findById(id).orElse(null);
    }

    public RegistroPersonaje setItem(RegistroPersonaje o){
        return  registroPersonajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        registroPersonajeRepository.deleteById(id);
    }
}
