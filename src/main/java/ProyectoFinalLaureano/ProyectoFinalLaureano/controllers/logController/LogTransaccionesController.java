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
@RequestMapping("/api/Informacionlogs")
@Tag(name = "LogTransacciones", description = "API para gestionar logs de transacciones")
public class LogTransaccionesController {

    @Autowired
    private LogTransaccionesService logTransaccionesService;

    @GetMapping("/transaccion/")
    @Operation(summary = "Obtener todos los logs de transacciones o filtrar por tipo de transacción")
    public List<LogTransacciones> obtenerLista(@RequestParam(required = false) TipoTransaccion tipoTransaccion) {
        if (tipoTransaccion == null) {
            return logTransaccionesService.getAll();
        } else {
            return logTransaccionesService.getBytipoTransaccion(tipoTransaccion);
        }
    }

    @GetMapping("/transaccion/{id}")
    @Operation(summary = "Obtener un log de transacción por ID")
    public LogTransacciones obtenerlogTransaccionesServiceLog(@PathVariable Long id) {
        return logTransaccionesService.getByID(id);
    }

    @PutMapping("/transaccion/{id}")
    @Operation(summary = "Actualizar un log de transacción por ID")
    public ResponseEntity<Object> actualizarlogTransaccionesServiceLog(@PathVariable Long id, @RequestBody LogTransacciones logActualizar) {
        if (logActualizar.getTransaccionId().equals(id)) {
            return ResponseEntity.ok(logTransaccionesService.setItem(logActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la transacción.");
        }
    }

    @PostMapping("/transaccion")
    @Operation(summary = "Crear un nuevo log de transacción")
    public LogTransacciones guardarlogTransaccionesServiceLog(@RequestBody LogTransacciones logGuardar) {
        return logTransaccionesService.setItem(logGuardar);
    }

    @DeleteMapping("/transaccion/{id}")
    @Operation(summary = "Eliminar un log de transacción por ID")
    public void borrarlogTransaccionesServiceLog(@PathVariable Long id) {
        logTransaccionesService.deleteByID(id);
    }
}