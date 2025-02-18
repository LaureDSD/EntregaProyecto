package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Usuario Tipo Controller", description = "Operaciones CRUD para la gestión de tipos de usuario")
public class UsuarioTipoController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    // CRUD Tipo Usuario

    @GetMapping("/tipo")
    @Operation(summary = "Obtener todos los tipos de usuario", description = "Retorna una lista de todos los tipos de usuario")
    public List<TipoUsuario> obtenerTiposUsuario() {
        return tipoUsuarioService.getAll();
    }

    @GetMapping("/tipo/{id}")
    @Operation(summary = "Obtener un tipo de usuario por ID", description = "Retorna un tipo de usuario específico basado en su ID")
    public TipoUsuario obtenerTipoUsuario(@PathVariable Long id) {
        return tipoUsuarioService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    @Operation(summary = "Actualizar un tipo de usuario", description = "Actualiza la información de un tipo de usuario existente")
    public ResponseEntity<Object> actualizarTipoUsuario(
            @PathVariable Long id,
            @RequestBody TipoUsuario tipoUsuarioActualizar) {
        if (tipoUsuarioActualizar.getTipoUsuarioId().equals(id)) {
            return ResponseEntity.ok(tipoUsuarioService.setItem(tipoUsuarioActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de usuario.");
        }
    }

    @PostMapping("/tipo")
    @Operation(summary = "Crear un nuevo tipo de usuario", description = "Crea un nuevo tipo de usuario con la información proporcionada")
    public TipoUsuario guardarTipoUsuario(@RequestBody TipoUsuario tipoUsuarioGuardar) {
        return tipoUsuarioService.setItem(tipoUsuarioGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    @Operation(summary = "Eliminar un tipo de usuario", description = "Elimina un tipo de usuario basado en su ID")
    public void borrarTipoUsuario(@PathVariable Long id) {
        tipoUsuarioService.deleteByID(id);
    }
}