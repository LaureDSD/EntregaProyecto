package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.InventarioPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioPersonajeService {

    @Autowired
    InventarioPersonajeRepository inventarioPersonajeRepository;

    public List<PersonajeItem> getAll(){
        return  inventarioPersonajeRepository.findAll();
    }

    public PersonajeItem getByID(Long id){
        return inventarioPersonajeRepository.findById(id).orElse(null);
    }

    public PersonajeItem setItem(PersonajeItem o){
        return  inventarioPersonajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        inventarioPersonajeRepository.deleteById(id);
    }

}
