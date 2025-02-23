package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.misionController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.MisionItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/misionItem")
public class MisionRecompensasController {

    @Autowired
    private MisionItemService misionObjetosService;

    //CRUD objetos de mision

    @GetMapping("")
    public List<MisionItem> obtenerListaObjetos(){
        return  misionObjetosService.getAll();
    }


    @GetMapping("/{mision_Item_Id}")
    public MisionItem obtenerObjetos(@RequestParam Long id){
        return misionObjetosService.getByID(id);
    }

    @PutMapping("/{mision_Item_Id}")
    public ResponseEntity<Object> actualizarObjetos(@PathVariable Long id, @RequestBody MisionItem objetoActualizar){
        if(objetoActualizar.getMision_item_id().equals(id)) {
            return ResponseEntity.ok( misionObjetosService.setItem(objetoActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del objeto.");
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> guardarObjetos(@PathVariable Long id,@RequestBody MisionItem objetoGuardar){
        if(objetoGuardar.getMision_item_id().equals(id)) {
            return ResponseEntity.ok( misionObjetosService.setItem(objetoGuardar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del objeto.");
        }
    }

    @DeleteMapping("/{mision_Item_Id}")
    public void borrarObjetos(@PathVariable Long id,@PathVariable Long id_objeto){
        misionObjetosService.deleteByID(id);
    }
}
