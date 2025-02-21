package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPCProducto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TiendaNPCService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/npc")
@Tag(name = "NPCProducto", description = "API para gestionar productos en la tienda de NPCs")
public class NpcProductoController {

    @Autowired
    private TiendaNPCService tiendaNPCService;

    @GetMapping("/tienda/")
    @Operation(summary = "Obtener todos los productos de las tiendas de NPCs")
    public List<NPCProducto> obtenerListaTiendaNPCs() {
        return tiendaNPCService.getAll();
    }

    @GetMapping("/tienda/{productoId}")
    @Operation(summary = "Obtener un producto específico de la tienda de un NPC")
    public NPCProducto obtenerProductoTiendaNPC(@PathVariable Long id) {
        return tiendaNPCService.getByID(id);
    }

    @PutMapping("/tienda/{Id}")
    @Operation(summary = "Actualizar un producto en la tienda de un NPC")
    public ResponseEntity<Object> actualizarProductoTiendaNPC(@PathVariable Long id,  @RequestBody NPCProducto tiendaActualizar) {
        if (tiendaActualizar.getNpc_producto_id().equals(id)) {
            return ResponseEntity.ok(tiendaNPCService.setItem(tiendaActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del producto en la tienda.");
        }
    }

    @PostMapping("/tienda/")
    @Operation(summary = "Crear un nuevo producto en la tienda de un NPC")
    public NPCProducto guardarProductoTiendaNPC(@RequestBody NPCProducto tiendaGuardar) {
        return tiendaNPCService.setItem(tiendaGuardar);
    }

    @DeleteMapping("tienda/{productoId}")
    @Operation(summary = "Eliminar un producto de la tienda de un NPC")
    public void borrarProductoTiendaNPC(@PathVariable Long id) {
        tiendaNPCService.deleteByID(id);
    }
}