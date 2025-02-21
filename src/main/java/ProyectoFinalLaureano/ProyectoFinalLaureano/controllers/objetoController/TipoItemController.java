package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.TipoItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objeto")
@Tag(name = "TipoItem", description = "API para gestionar tipos de ítems")
public class TipoItemController {

    @Autowired
    private TipoItemService tipoItemService;

    @GetMapping("/tipo/")
    @Operation(summary = "Obtener todos los tipos de ítems")
    public List<TipoItem> obtenerListaTiposItem() {
        return tipoItemService.getAll();
    }

    @GetMapping("/tipo/{id}")
    @Operation(summary = "Obtener un tipo de ítem por ID")
    public TipoItem obtenerTipoItem(@PathVariable Long id) {
        return tipoItemService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    @Operation(summary = "Actualizar un tipo de ítem por ID")
    public ResponseEntity<Object> actualizarTipoItem(@PathVariable Long id, @RequestBody TipoItem tipoItemActualizar) {
        if (tipoItemActualizar.getTipoItemId().equals(id)) {
            return ResponseEntity.ok(tipoItemService.setItem(tipoItemActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de ítem.");
        }
    }

    @PostMapping("/tipo")
    @Operation(summary = "Crear un nuevo tipo de ítem")
    public TipoItem guardarTipoItem(@RequestBody TipoItem tipoItemGuardar) {
        return tipoItemService.setItem(tipoItemGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    @Operation(summary = "Eliminar un tipo de ítem por ID")
    public void borrarTipoItem(@PathVariable Long id) {
        tipoItemService.deleteByID(id);
    }
}