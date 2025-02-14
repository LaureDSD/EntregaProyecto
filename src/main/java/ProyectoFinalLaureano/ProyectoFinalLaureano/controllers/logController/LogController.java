package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersoanje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogTransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @Autowired
    private LogPersonajeService logPersonajeService;

    @Autowired
    private LogTransaccionesService logTransaccionesService;


    //Seccion usuarios

    @GetMapping("/usuario/")
    public List<LogUsuario> obtenerUsuariosLog(){
        return  logService.getAll();
    }

    @GetMapping("/usuario/{id}")
    public LogUsuario obtenerUsuarioLog(@PathVariable Long id){
        return logService.getByID(id);
    }

    @PutMapping("/usuario/{id}")
    public LogUsuario actualizarUsuarioLog(@PathVariable Long id, @RequestBody LogUsuario logActualizar){
        logActualizar.setLogId(id);
        return  logService.setItem(logActualizar);
    }

    @PostMapping("/usuario")
    public LogUsuario guardarUsuarioLog(@RequestBody LogUsuario logGuardar){
        return  logService.setItem(logGuardar);
    }

    @DeleteMapping("/usuario/{id}")
    public void borrarUsuarioLog (@PathVariable Long id){
        logService.deleteByID(id);
    }


    //Seccion persoanjes

    @GetMapping("/persoanje/")
    public List<LogPersoanje> obtenerPersonajesLog(){
        return  logPersonajeService.getAll();
    }

    @GetMapping("/persoanje/{id}")
    public LogPersoanje obtenerPersonajeLog(@PathVariable Long id){
        return logPersonajeService.getByID(id);
    }

    @PutMapping("/persoanje/{id}")
    public LogPersoanje actualizarPersonajeLog(@PathVariable Long id, @RequestBody LogPersoanje logActualizar){
        logActualizar.setRegistroCazaId(id);
        return  logPersonajeService.setItem(logActualizar);
    }

    @PostMapping("/persoanje")
    public LogPersoanje guardarPersonajeLog(@RequestBody LogPersoanje logGuardar){
        return  logPersonajeService.setItem(logGuardar);
    }

    @DeleteMapping("/persoanje/{id}")
    public void borrarPersonajeLog (@PathVariable Long id){
        logPersonajeService.deleteByID(id);
    }







}
