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
@RequestMapping("/templates/admin/public/admin/api/Informacionlogs")
@Tag(name = "LogUsuario", description = "API para gestionar logs de usuarios")
public class LogController {

    @Autowired
    private LogUsuarioService logService;

    @GetMapping("/usuario/")
    @Operation(summary = "Obtener todos los logs de usuarios o filtrar por tipo de log")
    public List<LogUsuario> obtenerLista(@RequestParam(required = false) TipoLog tipoLog) {
        if (tipoLog == null) {
            return logService.getAll();
        } else {
            return logService.getBytipoLog(tipoLog);
        }
    }

    @GetMapping("/usuario/{id}")
    @Operation(summary = "Obtener un log de usuario por ID")
    public LogUsuario obtenerUsuarioLog(@PathVariable Long id) {
        return logService.getByID(id);
    }

    @PutMapping("/usuario/{id}")
    @Operation(summary = "Actualizar un log de usuario por ID")
    public ResponseEntity<Object> actualizarUsuarioLog(@PathVariable Long id, @RequestBody LogUsuario logActualizar) {
        if (logActualizar.getLogId().equals(id)) {
            return ResponseEntity.ok(logService.setItem(logActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del log.");
        }
    }

    @PostMapping("/usuario")
    @Operation(summary = "Crear un nuevo log de usuario")
    public LogUsuario guardarUsuarioLog(@RequestBody LogUsuario logGuardar) {
        return logService.setItem(logGuardar);
    }

    @DeleteMapping("/usuario/{id}")
    @Operation(summary = "Eliminar un log de usuario por ID")
    public void borrarUsuarioLog(@PathVariable Long id) {
        logService.deleteByID(id);
    }
}