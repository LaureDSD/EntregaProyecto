package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogPersonajeMonstruoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/admin/Informacionlogs")
@Tag(name = "LogPersonajeMonstruo", description = "API para gestionar logs de personajes y monstruos")
public class LogPersonajeController {

    @Autowired
    private LogPersonajeMonstruoService logPersonajeService;

    @GetMapping("/logpersonaje/")
    @Operation(summary = "Obtener todos los logs de personajes y monstruos")
    public List<LogPersonajeMonstruo> obtenerPersonajesLog() {
        return logPersonajeService.getAll();
    }

    @GetMapping("/personaje/{id}")
    @Operation(summary = "Obtener un log de personaje o monstruo por ID")
    public LogPersonajeMonstruo obtenerPersonajeLog(@PathVariable Long id) {
        return logPersonajeService.getByID(id);
    }

    @PutMapping("/personaje/{id}")
    @Operation(summary = "Actualizar un log de personaje o monstruo por ID")
    public ResponseEntity<Object> actualizarPersonajeLog(@PathVariable Long id, @RequestBody LogPersonajeMonstruo logActualizar) {
        if (logActualizar.getRegistroId().equals(id)) {
            return ResponseEntity.ok(logPersonajeService.setItem(logActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del personaje o monstruo.");
        }
    }

    @PostMapping("/personaje")
    @Operation(summary = "Crear un nuevo log de personaje o monstruo")
    public LogPersonajeMonstruo guardarPersonajeLog(@RequestBody LogPersonajeMonstruo logGuardar) {
        return logPersonajeService.setItem(logGuardar);
    }

    @DeleteMapping("/personaje/{id}")
    @Operation(summary = "Eliminar un log de personaje o monstruo por ID")
    public void borrarPersonajeLog(@PathVariable Long id) {
        logPersonajeService.deleteByID(id);
    }
}