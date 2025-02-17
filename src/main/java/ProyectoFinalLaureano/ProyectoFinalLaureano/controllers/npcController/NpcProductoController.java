package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProducto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProductoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TiendaNPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/npc")
public class NpcProductoController {

    @Autowired
    private TiendaNPCService tiendaNPCService;

    // CRUD TIENDA NPC (NPC PRODUCTO)

    @GetMapping("/{npcId}/tienda/")
    public List<NPCProducto> obtenerListaTiendaNPC() {
        return tiendaNPCService.getAll();
    }

    @GetMapping("/{npcId}/tienda/{productoId}")
    public NPCProducto obtenerProductoTiendaNPC(@PathVariable Long npcId, @PathVariable Long productoId) {
        return tiendaNPCService.getByID(new NPCProductoId(npcId, productoId));
    }

    @PutMapping("/{npcId}/tienda/{productoId}")
    public ResponseEntity<Object> actualizarProductoTiendaNPC(@PathVariable Long npcId, @PathVariable Long productoId, @RequestBody NPCProducto tiendaActualizar) {
        if (tiendaActualizar.getId().equals(new NPCProductoId(npcId, productoId))) {
            return ResponseEntity.ok(tiendaNPCService.setItem(tiendaActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del producto en la tienda.");
        }
    }

    @PostMapping("/{npcId}/tienda/")
    public NPCProducto guardarProductoTiendaNPC(@RequestBody NPCProducto tiendaGuardar) {
        return tiendaNPCService.setItem(tiendaGuardar);
    }

    @DeleteMapping("/{npcId}/tienda/{productoId}")
    public void borrarProductoTiendaNPC(@PathVariable Long npcId, @PathVariable Long productoId) {
        tiendaNPCService.deleteByID(new NPCProductoId(npcId, productoId));
    }

}