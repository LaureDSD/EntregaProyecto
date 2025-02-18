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
public class LogTransaccionesController {

    @Autowired
    private LogTransaccionesService logTransaccionesService;

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
        if(logActualizar.getTransaccionId().equals(id)) {
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
