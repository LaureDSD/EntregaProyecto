package ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersoanje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository.LogPesonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogPersonajeService {

    @Autowired
    private LogPesonajeRepository logPesonajeRepository;

    public List<LogPersoanje> getAll(){
        return  logPesonajeRepository.findAll();
    }

    public LogPersoanje getByID(Long id){
        return logPesonajeRepository.findById(id).orElse(null);
    }

    public LogPersoanje setItem(LogPersoanje o){
        return  logPesonajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        logPesonajeRepository.deleteById(id);
    }

}
