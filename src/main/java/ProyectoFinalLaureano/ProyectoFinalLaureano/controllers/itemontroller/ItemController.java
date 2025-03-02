package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.itemontroller;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.TipoItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@Tag(name = "Objeto", description = "API para gestionar objetos (ítems)")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private TipoItemService tipoItemService;

    @GetMapping("/")
    @Operation(summary = "Obtener todos los ítems o filtrar por tipo de ítem")
    public List<Item> obtenerListaItems(@RequestParam(required = false) Long id) {
        if (id == null) {
            return itemService.getAll();
        } else {
            TipoItem tipoItem = new TipoItem();
            tipoItem.setTipoItemId(id);
            return itemService.getBytipoItem(tipoItem);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un ítem por ID")
    public Item obtenerItem(@PathVariable Long id) {
        return itemService.getByID(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un ítem por ID")
    public ResponseEntity<Object> actualizarItem(@PathVariable Long id, @RequestBody Item itemActualizar) {
        if (itemActualizar.getItem_id().equals(id)) {
            return ResponseEntity.ok(itemService.setItem(itemActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del ítem.");
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo ítem")
    public Item guardarItem(@RequestBody Item itemGuardar) {
        //Mejora de input
        long tipo = 1L;
        if(itemGuardar.getTipoItem().getTipoItemId()!=null){
            tipo = itemGuardar.getTipoItem().getTipoItemId();
        }
        itemGuardar.setTipoItem( tipoItemService.getByID( 1L ));

        if(itemGuardar.getEstadisticas()==null){
            itemGuardar.setEstadisticas(new EstadisticasGenerales());
        };
        return itemService.setItem(itemGuardar);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un ítem por ID")
    public void borrarItem(@PathVariable Long id) {
        itemService.deleteByID(id);
    }
}