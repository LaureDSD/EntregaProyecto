package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.TipoNPCService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/npc")
@Tag(name = "TipoNPC", description = "API para gestionar tipos de NPCs")
public class NpcTipoController {

    @Autowired
    private TipoNPCService tipoNPCService;

    @GetMapping("/tipo/")
    @Operation(summary = "Obtener todos los tipos de NPCs")
    public List<TipoNPC> obtenerListaTiposNPC() {
        return tipoNPCService.getAll();
    }

    @GetMapping("/tipo/{id}")
    @Operation(summary = "Obtener un tipo de NPC por ID")
    public TipoNPC obtenerTipoNPC(@PathVariable Long id) {
        return tipoNPCService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    @Operation(summary = "Actualizar un tipo de NPC por ID")
    public ResponseEntity<Object> actualizarTipoNPC(@PathVariable Long id, @RequestBody TipoNPC tipoNPCActualizar) {
        if (tipoNPCActualizar.getTipo_npc_id().equals(id)) {
            return ResponseEntity.ok(tipoNPCService.setItem(tipoNPCActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de NPC.");
        }
    }

    @PostMapping("/tipo")
    @Operation(summary = "Crear un nuevo tipo de NPC")
    public TipoNPC guardarTipoNPC(@RequestBody TipoNPC tipoNPCGuardar) {
        return tipoNPCService.setItem(tipoNPCGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    @Operation(summary = "Eliminar un tipo de NPC por ID")
    public void borrarTipoNPC(@PathVariable Long id) {
        tipoNPCService.deleteByID(id);
    }
}