package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.LogrosPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.LogrosPersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logros")
@Tag(name = "Personaje Logros Controller", description = "Operaciones CRUD para la gestión de logros de personajes")
public class LogrosPersonajeController {

    @Autowired
    private LogrosPersonajeService logrosPersonajeService;

    // CRUD LOGROS PERSONAJE

    @GetMapping("/")
    @Operation(summary = "Obtener todos los logros de los personajes", description = "Retorna una lista de todos los logros asociados a los personajes")
    public List<LogrosPersonaje> obtenerListaLogrosPersonajes() {
        return logrosPersonajeService.getAll();
    }

    @GetMapping("/{logros_id}")
    @Operation(summary = "Obtener logros de un personaje específico", description = "Retorna los logros asociados a un personaje específico")
    public LogrosPersonaje obtenerLogrosPersonaje(@PathVariable Long logros_id) {
        return logrosPersonajeService.getByID(logros_id);
    }

    @PutMapping("/{personajeId}")
    @Operation(summary = "Actualizar un logro de un personaje", description = "Actualiza la información de un logro específico asociado a un personaje")
    public ResponseEntity<Object> actualizarLogroPersonaje(
            @PathVariable Long logros_id,
            @RequestBody LogrosPersonaje logroActualizar) {
        if (logroActualizar.getLogro_id().equals(logros_id)) {
            return ResponseEntity.ok(logrosPersonajeService.setItem(logroActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del logro del personaje.");
        }
    }

    @PostMapping("/{logros_id}")
    @Operation(summary = "Crear un nuevo logro para un personaje", description = "Crea un nuevo logro asociado a un personaje")
    public LogrosPersonaje guardarLogroPersonaje(
            @PathVariable Long logros_id,
            @RequestBody LogrosPersonaje logroGuardar) {
        logroGuardar.setLogro_id(logros_id);
        return logrosPersonajeService.setItem(logroGuardar);
    }

    @DeleteMapping("/{logros_Id}")
    @Operation(summary = "Eliminar un logro de un personaje", description = "Elimina un logro específico asociado a un personaje")
    public void borrarLogroPersonaje(@PathVariable Long logros_Id) {
        logrosPersonajeService.deleteByID(logros_Id);
    }
}