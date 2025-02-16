package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;
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
public class NPCController {

    @Autowired
    private NPCService npcService;

    @Autowired
    private TipoNPCService tipoNPCService;

    @Autowired
    private TiendaNPCService tiendaNPCService;

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

    // CRUD NPC

    @GetMapping("/")
    public List<NPC> obtenerListaNPCs(@RequestParam(required = false) TipoNPC tipoNPC) {
        if(tipoNPC==null) {
            return npcService.getAll();
        }else{
            return npcService.getBytipoNPC(tipoNPC);
        }
    }

    @GetMapping("/{id}")
    public NPC obtenerNPC(@PathVariable Long id) {
        return npcService.getByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarNPC(@PathVariable Long id, @RequestBody NPC npcActualizar) {
        if (npcActualizar.getNpc_id().equals(id)) {
            return ResponseEntity.ok(npcService.setItem(npcActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del NPC.");
        }
    }

    @PostMapping
    public NPC guardarNPC(@RequestBody NPC npcGuardar) {
        return npcService.setItem(npcGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrarNPC(@PathVariable Long id) {
        npcService.deleteByID(id);
    }

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