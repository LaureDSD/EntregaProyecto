package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.misionController.MisionController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.tienda.NPCProducto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO.NpcDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO.TiendaDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NPCService;
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
    public List<NpcDTO> obtenerListaNPCs(@RequestParam(required = false) TipoNPC tipoNPC) {
        if(tipoNPC==null) {
            return conversorListaNPCDTO(npcService.getAll());
        }else{
            return conversorListaNPCDTO(npcService.getBytipoNPC(tipoNPC));
        }
    }

    @GetMapping("/{id}")
    public NpcDTO obtenerNPC(@PathVariable Long id) {
        return conversorNPCDTO(npcService.getByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarNPC(@PathVariable Long id, @RequestBody NPC npcActualizar) {
        if (npcActualizar.getNpc_id().equals(id)) {
            return ResponseEntity.ok(conversorNPCDTO(npcService.setItem(npcActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del NPC.");
        }
    }

    @PostMapping
    public NpcDTO guardarNPC(@RequestBody NPC npcGuardar) {
        return conversorNPCDTO(npcService.setItem(npcGuardar));
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
        npcDTO.setId(n.getNpc_id());
        npcDTO.setImagen(n.getImagen());
        npcDTO.setNombre(n.getNombre());
        npcDTO.setDescripcion(n.getDescripcion());
        npcDTO.setTipoNPC(n.getTipoNPC());
        npcDTO.setTienda(NPCController.conversorListaTiendaDTO(n.getNpcProductos()));
        npcDTO.setMisiones(MisionController.conversorListaMisionDTO(n.getMisiones()));
        return  npcDTO;
    }

    //Conversor Lista
    public static List<TiendaDTO> conversorListaTiendaDTO(List<NPCProducto> l){
        return l.stream().map(NPCController::conversorTiendaDTO).toList();
    }

    //Conversor Unico
    private static TiendaDTO conversorTiendaDTO(NPCProducto npcProducto) {
        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setItem(npcProducto.getItem());
        tiendaDTO.setCantidadVenta(npcProducto.getCantidadVenta());
        tiendaDTO.setPrecioCompra(npcProducto.getPrecioCompra());
        tiendaDTO.setCantidadVenta(npcProducto.getCantidadVenta());
        return  tiendaDTO;
    }

}