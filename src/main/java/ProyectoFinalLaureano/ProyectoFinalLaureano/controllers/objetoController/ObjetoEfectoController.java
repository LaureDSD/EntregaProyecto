package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService.ItemEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService.TipoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objeto")
public class ObjetoEfectoController {

    @Autowired
    private ItemEfectoService itemEfectoService;

    // CRUD ITEM EFECTO

    @GetMapping("/efecto/")
    public List<ItemEfecto> obtenerListaEfectosItems() {
        return itemEfectoService.getAll();
    }

    @GetMapping("/{itemId}/efecto/")
    public List<ItemEfecto> obtenerListaEfectosItem(@PathVariable Long itemId) {
        return itemEfectoService.getByObjetoId(itemId);
    }

    @GetMapping("/{itemId}/efecto/{efectoId}")
    public ItemEfecto obtenerEfectoItem(@PathVariable Long itemId, @PathVariable Long efectoId) {
        return itemEfectoService.getByID(new ItemEfectoId(itemId, efectoId));
    }

    @PutMapping("/{itemId}/efecto/{efectoId}")
    public ResponseEntity<Object> actualizarEfectoItem(@PathVariable Long itemId, @PathVariable Long efectoId, @RequestBody ItemEfecto efectoActualizar) {
        if (efectoActualizar.getId().equals(new ItemEfectoId(itemId, efectoId))) {
            return ResponseEntity.ok(itemEfectoService.setItem(efectoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del efecto.");
        }
    }

    @PostMapping("/{itemId}/efecto/")
    public ItemEfecto guardarEfectoItem(@RequestBody ItemEfecto efectoGuardar) {
        return itemEfectoService.setItem(efectoGuardar);
    }

    @DeleteMapping("/{itemId}/efecto/{efectoId}")
    public void borrarEfectoItem(@PathVariable Long itemId, @PathVariable Long efectoId) {
        itemEfectoService.deleteByID(new ItemEfectoId(itemId, efectoId));
    }
}