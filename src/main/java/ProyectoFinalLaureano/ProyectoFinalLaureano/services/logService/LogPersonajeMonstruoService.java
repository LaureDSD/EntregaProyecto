package ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersoanjeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository.LogPesonajeMonstruoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogPersonajeMonstruoService {

    @Autowired
    private LogPesonajeMonstruoRepository logPesonajeRepository;

    public List<LogPersoanjeMonstruo> getAll(){
        return  logPesonajeRepository.findAll();
    }

    public LogPersoanjeMonstruo getByID(Long id){
        return logPesonajeRepository.findById(id).orElse(null);
    }

    public LogPersoanjeMonstruo setItem(LogPersoanjeMonstruo o){
        return  logPesonajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        logPesonajeRepository.deleteById(id);
    }

}
