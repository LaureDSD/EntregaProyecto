package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoLog;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoTransaccion;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogPersonajeMonstruoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogTransaccionesService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogPersonajeController {

    @Autowired
    private LogPersonajeMonstruoService logPersonajeService;

    //CRUD LOG PERSOANJES_MONSTRUOS

    @GetMapping("/persoanje/")
    public List<LogPersonajeMonstruo> obtenerPersonajesLog(){
        return  logPersonajeService.getAll();
    }

    @GetMapping("/persoanje/{id}")
    public LogPersonajeMonstruo obtenerPersonajeLog(@PathVariable Long id){
        return logPersonajeService.getByID(id);
    }

    @PutMapping("/persoanje/{id}")
    public ResponseEntity<Object> actualizarPersonajeLog(@PathVariable Long id, @RequestBody LogPersonajeMonstruo logActualizar){
        if(logActualizar.getRegistroId().equals(id)) {
            return ResponseEntity.ok( logPersonajeService.setItem(logActualizar) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del personanje.");
        }
    }

    @PostMapping("/persoanje")
    public LogPersonajeMonstruo guardarPersonajeLog(@RequestBody LogPersonajeMonstruo logGuardar){
        return  logPersonajeService.setItem(logGuardar);
    }

    @DeleteMapping("/persoanje/{id}")
    public void borrarPersonajeLog (@PathVariable Long id){
        logPersonajeService.deleteByID(id);
    }


}
