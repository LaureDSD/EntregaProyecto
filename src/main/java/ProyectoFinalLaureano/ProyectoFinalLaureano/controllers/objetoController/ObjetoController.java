package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objeto")
public class ObjetoController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemEfectoService efectoService;

    @Autowired
    private TipoItemService tipoItemService;




    // CRUD ITEM
    @GetMapping("/")
    public List<Item> obtenerObjeto(){
        return  itemService.getAll();
    }

    @GetMapping("/{id}")
    public Item obtener(@PathVariable Long id){
        return itemService.getByID(id);
    }

    @PutMapping("/{id}")
    public  Item actualizar(@PathVariable Long id, @RequestBody Item objetoActualizar){
        objetoActualizar.setItem_id(id);
        return  itemService.setItem(objetoActualizar);
    }

    @PostMapping
    public Item guardar(@RequestBody Item usuarioGuardar){
        return  itemService.setItem(usuarioGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        itemService.deleteByID(id);
    }

}
