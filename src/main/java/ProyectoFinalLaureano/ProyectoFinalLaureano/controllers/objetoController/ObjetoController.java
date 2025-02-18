package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController.EfectoEstadoController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController.EstadisticasController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfecto;
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
            tipoItem.setTipoItemId(id);
            return itemService.getBytipoItem(tipoItem);
        }
    }

    @GetMapping("/{id}")
    public Item obtenerItem(@PathVariable Long id) {
        return itemService.getByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarItem(@PathVariable Long id, @RequestBody Item itemActualizar) {
        if (itemActualizar.getItemId().equals(id)) {
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


}