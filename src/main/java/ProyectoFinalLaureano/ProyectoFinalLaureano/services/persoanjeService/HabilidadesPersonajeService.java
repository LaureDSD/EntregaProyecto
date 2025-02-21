package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.HabilidadesPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadesPersonajeService {
    @Autowired
    HabilidadesPersonajeRepository habilidadesPersonajeRepository;

    public List<PersonajeHabilidad> getAll(){
        return  habilidadesPersonajeRepository.findAll();
    }

    public PersonajeHabilidad getByID(Long id){
        return habilidadesPersonajeRepository.findById(id).orElse(null);
    }

    public PersonajeHabilidad setItem(PersonajeHabilidad o){
        return  habilidadesPersonajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        habilidadesPersonajeRepository.deleteById(id);
    }


}
