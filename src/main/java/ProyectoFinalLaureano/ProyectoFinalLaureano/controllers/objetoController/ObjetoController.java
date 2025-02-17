package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController.EfectoEstadoController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController.EstadisticasController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfecto;
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
    public List<ItemDTO> obtenerListaItems(@RequestParam(required = false) Long id) {
        if(id==null) {
            return conversorListaItemDTO(itemService.getAll());
        }else{
            TipoItem tipoItem = new TipoItem();
            tipoItem.setTipo_item_id(id);
            return conversorListaItemDTO(itemService.getBytipoItem(tipoItem));
        }
    }

    @GetMapping("/{id}")
    public ItemDTO obtenerItem(@PathVariable Long id) {
        return conversorItemDTO(itemService.getByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarItem(@PathVariable Long id, @RequestBody Item itemActualizar) {
        if (itemActualizar.getItem_id().equals(id)) {
            return ResponseEntity.ok(conversorItemDTO(itemService.setItem(itemActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del ítem.");
        }
    }

    @PostMapping
    public ItemDTO guardarItem(@RequestBody Item itemGuardar) {
        return conversorItemDTO(itemService.setItem(itemGuardar));
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
        itemDTO.setId(i.getItem_id());
        itemDTO.setImagen(i.getImagen());
        itemDTO.setNombre(i.getNombre());
        itemDTO.setTipoItem(i.getTipoItem());
        itemDTO.setAcumulaciones(i.getAcumulaciones_max());
        itemDTO.setEstadisticas(EstadisticasController.conversorEstadisticasDTO(i.getEstadisticas()));
        itemDTO.setEfectos(
                EfectoEstadoController.conversorListaEstadoDTO(
                        i.getEfectos().stream().map(ItemEfecto::getEfecto).toList()));
        return itemDTO;
    }
}