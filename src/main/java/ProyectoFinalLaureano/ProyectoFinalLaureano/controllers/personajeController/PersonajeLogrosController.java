package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.LogrosPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.LogrosPersoanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeLogrosController {

    @Autowired
    private LogrosPersoanjeService logrosPersonajeService;

    // CRUD LOGROS PERSONAJE

    /*
    @GetMapping("{personajeId}/logros/")
    public List<LogrosPersonaje> obtenerListaLogrosPersonaje() {
        return logrosPersonajeService.getAll();
    }*/

    @GetMapping("/{personajeId}/logros/")
    public LogrosPersonaje obtenerLogroPersonaje(@PathVariable Long personajeId, @PathVariable Long logroId) {
        return logrosPersonajeService.getByID(personajeId);
    }

    @PutMapping("/{personajeId}/logros/")
    public ResponseEntity<Object> actualizarLogroPersonaje(@PathVariable Long personajeId, @RequestBody LogrosPersonaje logroActualizar) {
        if (logroActualizar.getPersonaje_id().equals(personajeId)) {
            return ResponseEntity.ok(logrosPersonajeService.setItem(logroActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del logro del personaje.");
        }
    }

    @PostMapping("{personajeId}/logros/")
    public LogrosPersonaje guardarLogroPersonaje(@RequestBody LogrosPersonaje logroGuardar) {
        return logrosPersonajeService.setItem(logroGuardar);
    }

    @DeleteMapping("{personajeId}/logros")
    public void borrarLogroPersonaje(@PathVariable Long personajeId) {
        logrosPersonajeService.deleteByID(personajeId);
    }
}