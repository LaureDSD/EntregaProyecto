package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.efecto.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.efecto.ItemEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService.ItemEfectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objeto")
@Tag(name = "ObjetoEfecto", description = "API para gestionar efectos de objetos (ítems)")
public class ObjetoEfectoController {

    @Autowired
    private ItemEfectoService itemEfectoService;

    @GetMapping("/efecto/")
    @Operation(summary = "Obtener todos los efectos de ítems")
    public List<ItemEfecto> obtenerListaEfectosItems() {
        return itemEfectoService.getAll();
    }

    @GetMapping("/{itemId}/efecto/")
    @Operation(summary = "Obtener todos los efectos de un ítem específico")
    public List<ItemEfecto> obtenerListaEfectosItem(@PathVariable Long itemId) {
        return itemEfectoService.getByObjetoId(itemId);
    }

    @GetMapping("/{itemId}/efecto/{efectoId}")
    @Operation(summary = "Obtener un efecto específico de un ítem")
    public ItemEfecto obtenerEfectoItem(@PathVariable Long itemId, @PathVariable Long efectoId) {
        return itemEfectoService.getByID(new ItemEfectoId(itemId, efectoId));
    }

    @PutMapping("/{itemId}/efecto/{efectoId}")
    @Operation(summary = "Actualizar un efecto de un ítem")
    public ResponseEntity<Object> actualizarEfectoItem(@PathVariable Long itemId, @PathVariable Long efectoId, @RequestBody ItemEfecto efectoActualizar) {
        if (efectoActualizar.getId().equals(new ItemEfectoId(itemId, efectoId))) {
            return ResponseEntity.ok(itemEfectoService.setItem(efectoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del efecto.");
        }
    }

    @PostMapping("/{itemId}/efecto/")
    @Operation(summary = "Crear un nuevo efecto para un ítem")
    public ItemEfecto guardarEfectoItem(@RequestBody ItemEfecto efectoGuardar) {
        return itemEfectoService.setItem(efectoGuardar);
    }

    @DeleteMapping("/{itemId}/efecto/{efectoId}")
    @Operation(summary = "Eliminar un efecto de un ítem")
    public void borrarEfectoItem(@PathVariable Long itemId, @PathVariable Long efectoId) {
        itemEfectoService.deleteByID(new ItemEfectoId(itemId, efectoId));
    }
}