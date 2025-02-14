package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/")
    public List<LogUsuario> obtenerUsuario(){
        return  logService.getAll();
    }

    @GetMapping("/{id}")
    public LogUsuario obtener(@PathVariable Long id){
        return logService.getByID(id);
    }

    @PutMapping("/{id}")
    public LogUsuario actualizar(@PathVariable Long id, @RequestBody LogUsuario logActualizar){
        logActualizar.setLogId(id);
        return  logService.setItem(logActualizar);
    }

    @PostMapping
    public LogUsuario guardar(@RequestBody LogUsuario logGuardar){
        return  logService.setItem(logGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        logService.deleteByID(id);
    }
}
