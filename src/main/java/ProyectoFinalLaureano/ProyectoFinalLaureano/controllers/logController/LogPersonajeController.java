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

    /**
     * Obtener todos los logs de personajes y monstruos.
     *
     * @return Lista de logs de personajes y monstruos.
     */
    @GetMapping("/logpersonaje/")
    @Operation(summary = "Obtener todos los logs de personajes y monstruos")
    public ResponseEntity<?> obtenerPersonajesLog() {
        try {
            List<LogPersonajeMonstruo> logs = logPersonajeService.getAll();
            return ResponseEntity.ok(logs);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los logs de personajes y monstruos: " + e.getMessage());
        }
    }

    /**
     * Obtener un log de personaje o monstruo por su ID.
     *
     * @param id el ID del log de personaje o monstruo.
     * @return El log de personaje o monstruo correspondiente al ID.
     */
    @GetMapping("/personaje/{id}")
    @Operation(summary = "Obtener un log de personaje o monstruo por ID")
    public ResponseEntity<?> obtenerPersonajeLog(@PathVariable Long id) {
        try {
            LogPersonajeMonstruo logPersonajeMonstruo = logPersonajeService.getByID(id);
            if (logPersonajeMonstruo == null) {
                return ResponseEntity.status(404).body("Log de personaje o monstruo no encontrado con ID: " + id);
            }
            return ResponseEntity.ok(logPersonajeMonstruo);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el log de personaje o monstruo: " + e.getMessage());
        }
    }

    /**
     * Actualizar un log de personaje o monstruo por su ID.
     *
     * @param id el ID del log a actualizar.
     * @param logActualizar los datos del log a actualizar.
     * @return Respuesta con el log actualizado o mensaje de error si los IDs no coinciden.
     */
    @PutMapping("/personaje/{id}")
    @Operation(summary = "Actualizar un log de personaje o monstruo por ID")
    public ResponseEntity<?> actualizarPersonajeLog(@PathVariable Long id, @RequestBody LogPersonajeMonstruo logActualizar) {
        try {
            if (logActualizar.getRegistroId().equals(id)) {
                return ResponseEntity.ok(logPersonajeService.setItem(logActualizar)); // Actualiza el log y devuelve la respuesta
            } else {
                return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del personaje o monstruo.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el log de personaje o monstruo: " + e.getMessage());
        }
    }

    /**
     * Crear un nuevo log de personaje o monstruo.
     *
     * @param logGuardar los datos del nuevo log.
     * @return El nuevo log de personaje o monstruo creado.
     */
    @PostMapping("/personaje")
    @Operation(summary = "Crear un nuevo log de personaje o monstruo")
    public ResponseEntity<?> guardarPersonajeLog(@RequestBody LogPersonajeMonstruo logGuardar) {
        try {
            LogPersonajeMonstruo nuevoLog = logPersonajeService.setItem(logGuardar);
            return ResponseEntity.status(201).body(nuevoLog);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el log de personaje o monstruo: " + e.getMessage());
        }
    }

    /**
     * Eliminar un log de personaje o monstruo por su ID.
     *
     * @param id el ID del log de personaje o monstruo a eliminar.
     * @return Un mensaje de éxito o error.
     */
    @DeleteMapping("/personaje/{id}")
    @Operation(summary = "Eliminar un log de personaje o monstruo por ID")
    public ResponseEntity<?> borrarPersonajeLog(@PathVariable Long id) {
        try {
            logPersonajeService.deleteByID(id);
            return ResponseEntity.ok("Log de personaje o monstruo eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el log de personaje o monstruo: " + e.getMessage());
        }
    }
}
