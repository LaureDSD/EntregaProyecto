package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.misionController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.recompensas.MisionObjetoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.recompensas.MisionObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionObjetosService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mision")
public class MisionRecompensasController {

    @Autowired
    private MisionObjetosService misionObjetosService;

    //CRUD objetos de mision

    @GetMapping("/objeto/")
    public List<MisionObjetos> obtenerListaObjetos(){
        return  misionObjetosService.getAll();
    }

    @GetMapping("{misionId}/objeto/")
    public List<MisionObjetos> obtenerListaObjeto(@RequestParam(required = false) Long id){
            return  misionObjetosService.getByMisionId(id);
    }

    @GetMapping("{misionId}/objeto/{objetoId}")
    public MisionObjetos obtenerObjetos(@RequestParam Long id_mision,@RequestParam Long id_objeto){
        return misionObjetosService.getByID(new MisionObjetoId(id_mision,id_objeto));
    }

    @PutMapping("{misionId}/objeto/{objetoId}")
    public ResponseEntity<Object> actualizarObjetos(@PathVariable Long id_mision,@PathVariable Long id_objeto, @RequestBody MisionObjetos objetoActualizar){
        if(objetoActualizar.getId().equals(new MisionObjetoId(id_mision,id_objeto))) {
            return ResponseEntity.ok( misionObjetosService.setItem(objetoActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del objeto.");
        }
    }

    @PostMapping("{misionId}/objeto/")
    public ResponseEntity<Object> guardarObjetos(@PathVariable Long id_mision,@RequestBody MisionObjetos objetoGuardar){
        if(objetoGuardar.getId().getMision_id().equals(id_mision)) {
            return ResponseEntity.ok( misionObjetosService.setItem(objetoGuardar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del objeto.");
        }
    }

    @DeleteMapping("{misionId}/objeto/{objetoId}")
    public void borrarObjetos(@PathVariable Long id_mision,@PathVariable Long id_objeto){
        misionObjetosService.deleteByID(new MisionObjetoId(id_mision,id_objeto));
    }
}
