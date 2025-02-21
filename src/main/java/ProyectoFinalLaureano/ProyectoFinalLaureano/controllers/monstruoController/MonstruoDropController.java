package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruoItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monstruo")
@Tag(name = "MonstruoDrop", description = "API para gestionar drops de objetos de monstruos")
public class MonstruoDropController {

    @Autowired
    private MonstruoItemService dropsObjetosService;

    @GetMapping("/drop/")
    @Operation(summary = "Obtener todos los drops de objetos")
    public List<MonstruoItem> obtenerListaDropsObjetos() {
        return dropsObjetosService.getAll();
    }

    @GetMapping("/{monstruoId}/drop/{dropId}")
    @Operation(summary = "Obtener un drop de objeto específico por ID de monstruo y ID de drop")
    public MonstruoItem obtenerDropObjeto(@PathVariable Long id) {
        return dropsObjetosService.getByID(id);
    }

    @PutMapping("/{monstruoId}/drop/{dropId}")
    @Operation(summary = "Actualizar un drop de objeto por ID de monstruo y ID de drop")
    public ResponseEntity<Object> actualizarDropObjeto(@PathVariable Long id,@RequestBody MonstruoItem dropActualizar) {
        if (dropActualizar.getMonstruo_item_id().equals(id)) {
            return ResponseEntity.ok(dropsObjetosService.setItem(dropActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del drop.");
        }
    }

    @PostMapping("/{monstruoId}/drop/")
    @Operation(summary = "Crear un nuevo drop de objeto para un monstruo")
    public MonstruoItem guardarDropObjeto(@RequestBody MonstruoItem dropGuardar) {
        return dropsObjetosService.setItem(dropGuardar);
    }

    @DeleteMapping("/{monstruoId}/drop/{dropId}")
    @Operation(summary = "Eliminar un drop de objeto por ID de monstruo y ID de drop")
    public void borrarDropObjeto(@PathVariable Long id) {
        dropsObjetosService.deleteByID(id);
    }
}