package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.enums.TipoTransaccion;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogTransaccionesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/Informacionlogs")
@Tag(name = "LogTransacciones", description = "API para gestionar logs de transacciones")
public class LogTransaccionesController {

    @Autowired
    private LogTransaccionesService logTransaccionesService;

    /**
     * Obtener todos los logs de transacciones o filtrar por tipo de transacción.
     *
     * @param tipoTransaccion el tipo de transacción para filtrar.
     * @return Lista de logs de transacciones.
     */
    @GetMapping("/transaccion/")
    @Operation(summary = "Obtener todos los logs de transacciones o filtrar por tipo de transacción")
    public ResponseEntity<?> obtenerLista(@RequestParam(required = false) TipoTransaccion tipoTransaccion) {
        try {
            List<LogTransacciones> logs;
            if (tipoTransaccion == null) {
                logs = logTransaccionesService.getAll();
            } else {
                logs = logTransaccionesService.getBytipoTransaccion(tipoTransaccion);
            }
            return ResponseEntity.ok(logs);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los logs de transacciones: " + e.getMessage());
        }
    }

    /**
     * Obtener un log de transacción por su ID.
     *
     * @param id el ID del log de transacción.
     * @return El log de transacción correspondiente al ID.
     */
    @GetMapping("/transaccion/{id}")
    @Operation(summary = "Obtener un log de transacción por ID")
    public ResponseEntity<?> obtenerlogTransaccionesServiceLog(@PathVariable Long id) {
        try {
            LogTransacciones logTransacciones = logTransaccionesService.getByID(id);
            if (logTransacciones == null) {
                return ResponseEntity.status(404).body("Log de transacción no encontrado con ID: " + id);
            }
            return ResponseEntity.ok(logTransacciones);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el log de transacción: " + e.getMessage());
        }
    }

    /**
     * Actualizar un log de transacción por su ID.
     *
     * @param id el ID del log a actualizar.
     * @param logActualizar los datos del log a actualizar.
     * @return Respuesta con el log actualizado o mensaje de error si los IDs no coinciden.
     */
    @PutMapping("/transaccion/{id}")
    @Operation(summary = "Actualizar un log de transacción por ID")
    public ResponseEntity<?> actualizarlogTransaccionesServiceLog(@PathVariable Long id, @RequestBody LogTransacciones logActualizar) {
        try {
            if (logActualizar.getTransaccion_id().equals(id)) {
                return ResponseEntity.ok(logTransaccionesService.setItem(logActualizar));
            } else {
                return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la transacción.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el log de transacción: " + e.getMessage());
        }
    }

    /**
     * Crear un nuevo log de transacción.
     *
     * @param logGuardar los datos del nuevo log.
     * @return El nuevo log de transacción creado.
     */
    @PostMapping("/transaccion")
    @Operation(summary = "Crear un nuevo log de transacción")
    public ResponseEntity<?> guardarlogTransaccionesServiceLog(@RequestBody LogTransacciones logGuardar) {
        try {
            LogTransacciones nuevoLog = logTransaccionesService.setItem(logGuardar);
            return ResponseEntity.status(201).body(nuevoLog);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el log de transacción: " + e.getMessage());
        }
    }

    /**
     * Eliminar un log de transacción por su ID.
     *
     * @param id el ID del log de transacción a eliminar.
     * @return Un mensaje de éxito o error.
     */
    @DeleteMapping("/transaccion/{id}")
    @Operation(summary = "Eliminar un log de transacción por ID")
    public ResponseEntity<?> borrarlogTransaccionesServiceLog(@PathVariable Long id) {
        try {
            logTransaccionesService.deleteByID(id);
            return ResponseEntity.ok("Log de transacción eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el log de transacción: " + e.getMessage());
        }
    }
}
