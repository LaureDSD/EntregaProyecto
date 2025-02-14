package ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public List<LogUsuario> getAll(){
        return  logRepository.findAll();
    }

    public LogUsuario getByID(long id){
        return logRepository.findById(id).orElse(null);
    }

    public LogUsuario setItem(LogUsuario o){
        return  logRepository.save(o);
    }

    public  void deleteByID(long id){
        logRepository.deleteById(id);
    }

}
