package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/npc")
public class npcController {

    @Autowired
    private NPCService npcService;

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
