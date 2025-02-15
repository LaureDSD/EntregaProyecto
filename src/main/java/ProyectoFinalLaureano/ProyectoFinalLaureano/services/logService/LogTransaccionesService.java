package ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoTransaccion;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.logRepository.LogTransaccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogTransaccionesService {
     @Autowired
     private LogTransaccionesRepository transaccionesNPCRepository;

    public List<LogTransacciones> getAll(){
        return  transaccionesNPCRepository.findAll();
    }

    public LogTransacciones getByID(Long id){
        return transaccionesNPCRepository.findById(id).orElse(null);
    }

    public LogTransacciones setItem(LogTransacciones o){
        return  transaccionesNPCRepository.save(o);
    }

    public  void deleteByID(Long id){
        transaccionesNPCRepository.deleteById(id);
    }

    public List<LogTransacciones> getBytipoTransaccion(TipoTransaccion tipoTransaccion) {
        return transaccionesNPCRepository.getBytipoTransaccion(tipoTransaccion);
    }
}
