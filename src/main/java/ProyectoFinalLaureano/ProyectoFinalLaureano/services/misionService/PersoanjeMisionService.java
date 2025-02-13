package ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.PersonajeMision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.PersonajeMisionId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.misionRepository.PersonajeMisionRepository;
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
}
