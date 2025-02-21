package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.PersonajeMisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeMisionService {
    @Autowired
    private PersonajeMisionRepository personajeMisionRepository;

    public List<PersonajeMision> getAll(){
        return  personajeMisionRepository.findAll();
    }

    public PersonajeMision getByID(Long id){
        return personajeMisionRepository.findById(id).orElse(null);
    }

    public PersonajeMision setItem(PersonajeMision o){
        return  personajeMisionRepository.save(o);
    }

    public  void deleteByID(Long id){
        personajeMisionRepository.deleteById(id);
    }

}
