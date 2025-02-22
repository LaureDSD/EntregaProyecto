package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoLog;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/Informacionlogs")
@Tag(name = "LogUsuario", description = "API para gestionar logs de usuarios")
public class LogController {

    @Autowired
    private LogUsuarioService logService;

    /**
     * Obtener todos los logs de usuarios o filtrar por tipo de log.
     *
     * @param tipoLog el tipo de log para filtrar (opcional).
     * @return Lista de logs de usuarios, filtrados por tipo si se especifica.
     */
    @GetMapping("/logusuario/")
    @Operation(summary = "Obtener todos los logs de usuarios o filtrar por tipo de log")
    public ResponseEntity<?> obtenerLista(@RequestParam(required = false) TipoLog tipoLog) {
        try {
            List<LogUsuario> logs;
            if (tipoLog == null) {
                logs = logService.getAll(); // Si no se especifica un tipo, se devuelven todos los logs
            } else {
                logs = logService.getBytipoLog(tipoLog); // Si se especifica un tipo, se filtran los logs por tipo
            }
            return ResponseEntity.ok(logs);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los logs de usuarios: " + e.getMessage());
        }
    }

    /**
     * Obtener un log de usuario por su ID.
     *
     * @param id el ID del log de usuario.
     * @return El log de usuario correspondiente al ID o un mensaje de error si no se encuentra.
     */
    @GetMapping("/usuario/{id}")
    @Operation(summary = "Obtener un log de usuario por ID")
    public ResponseEntity<?> obtenerUsuarioLog(@PathVariable Long id) {
        try {
            LogUsuario logUsuario = logService.getByID(id);
            if (logUsuario == null) {
                return ResponseEntity.status(404).body("Log de usuario no encontrado con ID: " + id);
            }
            return ResponseEntity.ok(logUsuario);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el log de usuario: " + e.getMessage());
        }
    }

    /**
     * Actualizar un log de usuario por su ID.
     *
     * @param id el ID del log a actualizar.
     * @param logActualizar los datos del log a actualizar.
     * @return Respuesta con el log actualizado o mensaje de error si los IDs no coinciden.
     */
    @PutMapping("/usuario/{id}")
    @Operation(summary = "Actualizar un log de usuario por ID")
    public ResponseEntity<?> actualizarUsuarioLog(@PathVariable Long id, @RequestBody LogUsuario logActualizar) {
        try {
            if (logActualizar.getLog_id().equals(id)) {
                return ResponseEntity.ok(logService.setItem(logActualizar)); // Actualiza el log y devuelve la respuesta
            } else {
                return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del log.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el log de usuario: " + e.getMessage());
        }
    }

    /**
     * Crear un nuevo log de usuario.
     *
     * @param logGuardar los datos del nuevo log.
     * @return El nuevo log de usuario creado.
     */
    @PostMapping("/usuario")
    @Operation(summary = "Crear un nuevo log de usuario")
    public ResponseEntity<?> guardarUsuarioLog(@RequestBody LogUsuario logGuardar) {
        try {
            LogUsuario nuevoLog = logService.setItem(logGuardar);
            return ResponseEntity.status(201).body(nuevoLog);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el log de usuario: " + e.getMessage());
        }
    }

    /**
     * Eliminar un log de usuario por su ID.
     *
     * @param id el ID del log de usuario a eliminar.
     * @return Un mensaje de éxito o error.
     */
    @DeleteMapping("/usuario/{id}")
    @Operation(summary = "Eliminar un log de usuario por ID")
    public ResponseEntity<?> borrarUsuarioLog(@PathVariable Long id) {
        try {
            logService.deleteByID(id);
            return ResponseEntity.ok("Log de usuario eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el log de usuario: " + e.getMessage());
        }
    }
}
