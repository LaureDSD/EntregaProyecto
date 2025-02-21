package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.DropsObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.DropsObjetosService;
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
    private DropsObjetosService dropsObjetosService;

    @GetMapping("/drop/")
    @Operation(summary = "Obtener todos los drops de objetos")
    public List<DropsObjetos> obtenerListaDropsObjetos() {
        return dropsObjetosService.getAll();
    }

    @GetMapping("/{monstruoId}/drop/{dropId}")
    @Operation(summary = "Obtener un drop de objeto específico por ID de monstruo y ID de drop")
    public DropsObjetos obtenerDropObjeto( @PathVariable Long id) {
        return dropsObjetosService.getByID(id);
    }

    @PutMapping("/{monstruoId}/drop/{dropId}")
    @Operation(summary = "Actualizar un drop de objeto por ID de monstruo y ID de drop")
    public ResponseEntity<Object> actualizarDropObjeto(@PathVariable Long id,@RequestBody DropsObjetos dropActualizar) {
        if (dropActualizar.getMonstruo_item_id().equals(id)) {
            return ResponseEntity.ok(dropsObjetosService.setItem(dropActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del drop.");
        }
    }

    @PostMapping("/{monstruoId}/drop/")
    @Operation(summary = "Crear un nuevo drop de objeto para un monstruo")
    public DropsObjetos guardarDropObjeto(@RequestBody DropsObjetos dropGuardar) {
        return dropsObjetosService.setItem(dropGuardar);
    }

    @DeleteMapping("/{monstruoId}/drop/{dropId}")
    @Operation(summary = "Eliminar un drop de objeto por ID de monstruo y ID de drop")
    public void borrarDropObjeto(@PathVariable Long id) {
        dropsObjetosService.deleteByID(id);
    }
}