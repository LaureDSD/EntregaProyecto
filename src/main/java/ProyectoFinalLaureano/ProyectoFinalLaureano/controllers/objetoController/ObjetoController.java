package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.itemDTO.ItemDTO;
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

    //Conversor Lista
    public static List<ItemDTO> conversorListaItemDTO(List<Item> l){
        return l.stream().map(ObjetoController::conversorItemDTO).toList();
    }

    //Conversor Unico DTO
    public static ItemDTO conversorItemDTO( Item i){
        ItemDTO itemDTO = new ItemDTO();
        return itemDTO;
    }
}