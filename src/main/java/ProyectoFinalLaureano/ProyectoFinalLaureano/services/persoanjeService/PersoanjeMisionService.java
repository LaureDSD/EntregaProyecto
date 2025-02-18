package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMisionId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.PersonajeMisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoanjeMisionService {
    @Autowired
    private PersonajeMisionRepository personajeMisionRepository;

    public List<PersonajeMision> getAll(){
        return  personajeMisionRepository.findAll();
    }

    public PersonajeMision getByID(PersonajeMisionId id){
        return personajeMisionRepository.findById(id).orElse(null);
    }

    public PersonajeMision setItem(PersonajeMision o){
        return  personajeMisionRepository.save(o);
    }

    public  void deleteByID(PersonajeMisionId id){
        personajeMisionRepository.deleteById(id);
    }

    public List<PersonajeMision> getByPersoanjeId(Long personajeId) {
        return personajeMisionRepository.getByPersonajeId(personajeId);
    }
}
