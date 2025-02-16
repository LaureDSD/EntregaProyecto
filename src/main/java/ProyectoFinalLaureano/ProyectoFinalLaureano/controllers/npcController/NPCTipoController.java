package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProducto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProductoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NPCService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TiendaNPCService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TipoNPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/npc")
public class NPCTipoController {

    @Autowired
    private TipoNPCService tipoNPCService;

    // CRUD TIPO NPC

    @GetMapping("/tipo/")
    public List<TipoNPC> obtenerListaTiposNPC() {
        return tipoNPCService.getAll();
    }

    @GetMapping("/tipo/{id}")
    public TipoNPC obtenerTipoNPC(@PathVariable Long id) {
        return tipoNPCService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    public ResponseEntity<Object> actualizarTipoNPC(@PathVariable Long id, @RequestBody TipoNPC tipoNPCActualizar) {
        if (tipoNPCActualizar.getTipo_npc_id().equals(id)) {
            return ResponseEntity.ok(tipoNPCService.setItem(tipoNPCActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de NPC.");
        }
    }

    @PostMapping("/tipo")
    public TipoNPC guardarTipoNPC(@RequestBody TipoNPC tipoNPCGuardar) {
        return tipoNPCService.setItem(tipoNPCGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    public void borrarTipoNPC(@PathVariable Long id) {
        tipoNPCService.deleteByID(id);
    }

}