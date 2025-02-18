package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.TipoMonstruoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monstruo")
@Tag(name = "TipoMonstruo", description = "API para gestionar tipos de monstruos")
public class MonstruoTipoController {

    @Autowired
    private TipoMonstruoService tipoMonstruoService;

    @GetMapping("/tipo/")
    @Operation(summary = "Obtener todos los tipos de monstruos")
    public List<TipoMonstruo> obtenerListaTiposMonstruo() {
        return tipoMonstruoService.getAll();
    }

    @GetMapping("/tipo/{id}")
    @Operation(summary = "Obtener un tipo de monstruo por ID")
    public TipoMonstruo obtenerTipoMonstruo(@PathVariable Long id) {
        return tipoMonstruoService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    @Operation(summary = "Actualizar un tipo de monstruo por ID")
    public ResponseEntity<Object> actualizarTipoMonstruo(@PathVariable Long id, @RequestBody TipoMonstruo tipoMonstruoActualizar) {
        if (tipoMonstruoActualizar.getTipoMonstruoId().equals(id)) {
            return ResponseEntity.ok(tipoMonstruoService.setItem(tipoMonstruoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de monstruo.");
        }
    }

    @PostMapping("/tipo")
    @Operation(summary = "Crear un nuevo tipo de monstruo")
    public TipoMonstruo guardarTipoMonstruo(@RequestBody TipoMonstruo tipoMonstruoGuardar) {
        return tipoMonstruoService.setItem(tipoMonstruoGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    @Operation(summary = "Eliminar un tipo de monstruo por ID")
    public void borrarTipoMonstruo(@PathVariable Long id) {
        tipoMonstruoService.deleteByID(id);
    }
}