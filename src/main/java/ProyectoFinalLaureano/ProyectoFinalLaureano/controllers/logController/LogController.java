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

    //Conversor Lista
    /*
    public static  xxxx conversorLista( List<> l){
        return l.stream().map( e  -> conversorDTO(e) );
    }

*/
    //Conversor Unico DTO
    /*
    public static xxxx conversorDTO(){
    }
*/
}
