package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NPCService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TiendaNPCService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TipoNPCService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/")
    public List<NPC> obtenerUsuario(){
        return  npcService.getAll();
    }

    @GetMapping("/{id}")
    public NPC obtener(@PathVariable Long id){
        return npcService.getByID(id);
    }

    @PutMapping("/{id}")
    public  NPC actualizar(@PathVariable Long id, @RequestBody NPC npcActualizar){
        npcActualizar.setNpc_id(id);
        return  npcService.setItem(npcActualizar);
    }

    @PostMapping
    public NPC guardar(@RequestBody NPC usuarioGuardar){
        return  npcService.setItem(usuarioGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        npcService.deleteByID(id);
    }
}
