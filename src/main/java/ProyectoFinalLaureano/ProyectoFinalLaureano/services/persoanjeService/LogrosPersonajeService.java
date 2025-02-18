package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.LogrosPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.LogrosPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogrosPersonajeService {
    @Autowired
    private LogrosPersonajeRepository logrosPersonajeRepository;

    public List<LogrosPersonaje> getAll(){
        return  logrosPersonajeRepository.findAll();
    }

    public LogrosPersonaje getByID(Long id){
        return logrosPersonajeRepository.findById(id).orElse(null);
    }

    public LogrosPersonaje setItem(LogrosPersonaje o){
        return  logrosPersonajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        logrosPersonajeRepository.deleteById(id);
    }
}
