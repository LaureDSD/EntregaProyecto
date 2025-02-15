package ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository.LogPesonajeMonstruoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogPersonajeMonstruoService {

    @Autowired
    private LogPesonajeMonstruoRepository logPesonajeRepository;

    public List<LogPersonajeMonstruo> getAll(){
        return  logPesonajeRepository.findAll();
    }

    public LogPersonajeMonstruo getByID(Long id){
        return logPesonajeRepository.findById(id).orElse(null);
    }

    public LogPersonajeMonstruo setItem(LogPersonajeMonstruo o){
        return  logPesonajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        logPesonajeRepository.deleteById(id);
    }

}
