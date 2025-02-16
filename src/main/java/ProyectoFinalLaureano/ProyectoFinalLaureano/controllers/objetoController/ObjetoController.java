package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objeto")
public class ObjetoController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemEfectoService itemEfectoService;

    @Autowired
    private TipoItemService tipoItemService;

    // CRUD TIPO ITEM

    @GetMapping("/tipo/")
    public List<TipoItem> obtenerListaTiposItem() {
        return tipoItemService.getAll();
    }

    @GetMapping("/tipo/{id}")
    public TipoItem obtenerTipoItem(@PathVariable Long id) {
        return tipoItemService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    public ResponseEntity<Object> actualizarTipoItem(@PathVariable Long id, @RequestBody TipoItem tipoItemActualizar) {
        if (tipoItemActualizar.getTipo_item_id().equals(id)) {
            return ResponseEntity.ok(tipoItemService.setItem(tipoItemActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de ítem.");
        }
    }

    @PostMapping("/tipo")
    public TipoItem guardarTipoItem(@RequestBody TipoItem tipoItemGuardar) {
        return tipoItemService.setItem(tipoItemGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    public void borrarTipoItem(@PathVariable Long id) {
        tipoItemService.deleteByID(id);
    }

    // CRUD ITEM

    @GetMapping("/")
    public List<Item> obtenerListaItems(@RequestParam(required = false) Long id) {
        if(id==null) {
            return itemService.getAll();
        }else{
            TipoItem tipoItem = new TipoItem();
            tipoItem.setTipo_item_id(id);
            return itemService.getBytipoItem(tipoItem);
        }
    }

    @GetMapping("/{id}")
    public Item obtenerItem(@PathVariable Long id) {
        return itemService.getByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarItem(@PathVariable Long id, @RequestBody Item itemActualizar) {
        if (itemActualizar.getItem_id().equals(id)) {
            return ResponseEntity.ok(itemService.setItem(itemActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del ítem.");
        }
    }

    @PostMapping
    public Item guardarItem(@RequestBody Item itemGuardar) {
        return itemService.setItem(itemGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrarItem(@PathVariable Long id) {
        itemService.deleteByID(id);
    }

    // CRUD ITEM EFECTO

    @GetMapping("/{itemId}/efecto/")
    public List<ItemEfecto> obtenerListaEfectosItem() {
        return itemEfectoService.getAll();
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