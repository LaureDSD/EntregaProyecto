package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.Npc;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NpcItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO.NpcDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.npcDTO.TiendaDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NpcService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TipoNpcService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/npc")
@Tag(name = "NPC", description = "API para gestionar NPCs")
public class NPCController {

    @Autowired
    private NpcService npcService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private TipoNpcService tipoNpcService;

    @GetMapping("/")
    @Operation(summary = "Obtener todos los NPCs o filtrar por tipo de NPC")
    public List<NpcDTO> obtenerListaNPCs(@RequestParam(required = false) TipoNPC tipoNPC) {
        if (tipoNPC == null) {
            return conversorListaNPCDTO(npcService.getAll());
        } else {
            return conversorListaNPCDTO(npcService.getBytipoNPC(tipoNPC));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un NPC por ID")
    public NpcDTO obtenerNPC(@PathVariable Long id) {
        return conversorNPCDTO(npcService.getByID(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un NPC por ID")
    public ResponseEntity<Object> actualizarNPC(@PathVariable Long id, @RequestBody Npc npcActualizar) {
        if (npcActualizar.getNpc_id().equals(id)) {
            return ResponseEntity.ok(conversorNPCDTO(npcService.setItem(npcActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del NPC.");
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo NPC")
    public NpcDTO guardarNPC(@RequestBody Npc npcGuardar) {
        //Optimizacion de imput
        long tipo = 1L;
        if(npcGuardar.getTipoNPC().getTipo_npc_id()!=null){
            tipo = npcGuardar.getTipoNPC().getTipo_npc_id();
        }
        npcGuardar.setTipoNPC( tipoNpcService.getByID(tipo));
        return conversorNPCDTO(npcService.setItem(npcGuardar));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un NPC por ID")
    public void borrarNPC(@PathVariable Long id) {
        npcService.deleteByID(id);
    }

    // Conversor Lista
    public  List<NpcDTO> conversorListaNPCDTO(List<Npc> l) {
        return l.stream().map(this::conversorNPCDTO).toList();
    }

    // Conversor Unico DTO
    public  NpcDTO conversorNPCDTO(Npc n) {
        NpcDTO npcDTO = new NpcDTO();
        npcDTO.setId(n.getNpc_id());
        npcDTO.setImagen(n.getImagen());
        npcDTO.setNombre(n.getNombre());
        npcDTO.setDescripcion(n.getDescripcion());
        npcDTO.setTipoNPC(n.getTipoNPC());
        npcDTO.setTienda(conversorListaTiendaDTO(n.getNpcProductos()));
        return npcDTO;
    }

    // Conversor Lista Tienda
    public  List<TiendaDTO> conversorListaTiendaDTO(List<NpcItem> l) {
        return l.stream().map(this::conversorTiendaDTO).toList();
    }

    // Conversor Unico Tienda
    private  TiendaDTO conversorTiendaDTO(NpcItem npcProducto) {
        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setItem( npcProducto.getItem());
        tiendaDTO.setCantidadVenta(npcProducto.getCantidadVenta());
        tiendaDTO.setPrecioCompra(npcProducto.getPrecioCompra());
        tiendaDTO.setCantidadVenta(npcProducto.getCantidadVenta());
        return tiendaDTO;
    }
}