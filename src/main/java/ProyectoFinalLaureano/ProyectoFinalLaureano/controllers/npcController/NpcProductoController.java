package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProducto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProductoId;
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

    @GetMapping("/{npcId}/tienda/")
    @Operation(summary = "Obtener todos los productos de la tienda de un NPC específico")
    public List<NPCProducto> obtenerListaTiendaNPC(@PathVariable Long npcId) {
        return tiendaNPCService.getByNpcId(npcId);
    }

    @GetMapping("/{npcId}/tienda/{productoId}")
    @Operation(summary = "Obtener un producto específico de la tienda de un NPC")
    public NPCProducto obtenerProductoTiendaNPC(@PathVariable Long npcId, @PathVariable Long productoId) {
        return tiendaNPCService.getByID(new NPCProductoId(npcId, productoId));
    }

    @PutMapping("/{npcId}/tienda/{productoId}")
    @Operation(summary = "Actualizar un producto en la tienda de un NPC")
    public ResponseEntity<Object> actualizarProductoTiendaNPC(@PathVariable Long npcId, @PathVariable Long productoId, @RequestBody NPCProducto tiendaActualizar) {
        if (tiendaActualizar.getId().equals(new NPCProductoId(npcId, productoId))) {
            return ResponseEntity.ok(tiendaNPCService.setItem(tiendaActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del producto en la tienda.");
        }
    }

    @PostMapping("/{npcId}/tienda/")
    @Operation(summary = "Crear un nuevo producto en la tienda de un NPC")
    public NPCProducto guardarProductoTiendaNPC(@RequestBody NPCProducto tiendaGuardar) {
        return tiendaNPCService.setItem(tiendaGuardar);
    }

    @DeleteMapping("/{npcId}/tienda/{productoId}")
    @Operation(summary = "Eliminar un producto de la tienda de un NPC")
    public void borrarProductoTiendaNPC(@PathVariable Long npcId, @PathVariable Long productoId) {
        tiendaNPCService.deleteByID(new NPCProductoId(npcId, productoId));
    }
}