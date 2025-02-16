package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoLog;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoTransaccion;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogPersonajeMonstruoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogUsuarioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogTransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogUsuarioService logService;

    @Autowired
    private LogPersonajeMonstruoService logPersonajeService;

    @Autowired
    private LogTransaccionesService logTransaccionesService;


    //CRUD LOG USUARIOS
    @GetMapping("/usuario/")
    public List<LogUsuario> obtenerLista(@RequestParam(required = false) TipoLog tipoLog){
        if(tipoLog==null){
            return  logService.getAll();
        }else{
            return logService.getBytipoLog(tipoLog);
        }
    }

    @GetMapping("/usuario/{id}")
    public LogUsuario obtenerUsuarioLog(@PathVariable Long id){
        return logService.getByID(id);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Object> actualizarUsuarioLog(@PathVariable Long id, @RequestBody LogUsuario logActualizar){
        if(logActualizar.getLogId().equals(id)) {
            return ResponseEntity.ok( logService.setItem(logActualizar) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del log.");
        }

    }

    @PostMapping("/usuario")
    public LogUsuario guardarUsuarioLog(@RequestBody LogUsuario logGuardar){
        return  logService.setItem(logGuardar);
    }

    @DeleteMapping("/usuario/{id}")
    public void borrarUsuarioLog (@PathVariable Long id){
        logService.deleteByID(id);
    }


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




    //CRUD LOG TRANSACCIONES

    @GetMapping("/transaccion/")
    public List<LogTransacciones> obtenerLista(@RequestParam(required = false) TipoTransaccion tipoTransaccion){
        if(tipoTransaccion==null){
            return  logTransaccionesService.getAll();
        }else{
            return logTransaccionesService.getBytipoTransaccion(tipoTransaccion);
        }
    }


    @GetMapping("/transaccion/{id}")
    public LogTransacciones obtenerlogTransaccionesServiceLog(@PathVariable Long id){
        return logTransaccionesService.getByID(id);
    }

    @PutMapping("/transaccion/{id}")
    public ResponseEntity<Object> actualizarlogTransaccionesServiceLog(@PathVariable Long id, @RequestBody LogTransacciones logActualizar){
        if(logActualizar.getTransaccion_id().equals(id)) {
            return ResponseEntity.ok( logTransaccionesService.setItem(logActualizar) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la transaction.");
        }
    }

    @PostMapping("/transaccion")
    public LogTransacciones guardarlogTransaccionesServiceLog(@RequestBody LogTransacciones logGuardar){
        return  logTransaccionesService.setItem(logGuardar);
    }

    @DeleteMapping("/transaccion/{id}")
    public void borrarlogTransaccionesServiceLog (@PathVariable Long id){
        logTransaccionesService.deleteByID(id);
    }

}
