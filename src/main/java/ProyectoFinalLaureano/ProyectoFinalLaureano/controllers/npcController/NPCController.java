package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProducto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProductoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO.NpcDTO;
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

    //Conversor Lista
    public static List<NpcDTO> conversorListaNPCDTO(List<NPC> l){
        return l.stream().map(NPCController::conversorNPCDTO).toList();
    }


    //Conversor Unico DTO
    public static NpcDTO conversorNPCDTO(NPC n){
        NpcDTO npcDTO = new NpcDTO();

        return  npcDTO;
    }

}