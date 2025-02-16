package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.misionController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
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
public class MisionController {

    @Autowired
    private MisionService misionService;

    //CRUD MSISIONES
    @GetMapping("/")
    public List<Mision> obtenerMisones(){
        return  misionService.getAll();
    }

    @GetMapping("/{id}")
    public Mision obtenerMisones(@PathVariable Long id){
        return misionService.getByID(id);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> actualizarMisones(@PathVariable Long id, @RequestBody Mision misionActualizar){
        if(misionActualizar.getMision_id().equals(id)) {
            return ResponseEntity.ok( misionService.setItem(misionActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la mision.");
        }
    }

    @PostMapping
    public Mision guardarMisones(@RequestBody Mision misionGuardar){
        return  misionService.setItem(misionGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrarMisones (@PathVariable Long id){
        misionService.deleteByID(id);
    }

}
