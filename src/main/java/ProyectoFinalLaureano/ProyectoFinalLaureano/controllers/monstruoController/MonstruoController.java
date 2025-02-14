package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monstruo")
public class MonstruoController {

    @Autowired
    private MonstruosService monstruosService;

    @GetMapping("/")
    public List<Monstruo> obtenerUsuario(){
        return  monstruosService.getAll();
    }

    @GetMapping("/{id}")
    public Monstruo obtener(@PathVariable Long id){
        return monstruosService.getByID(id);
    }

    @PutMapping("/{id}")
    public  Monstruo actualizar(@PathVariable Long id, @RequestBody Monstruo monstruoActualizar){
        monstruoActualizar.setMonstruo_id(id);
        return  monstruosService.setItem(monstruoActualizar);
    }

    @PostMapping
    public Monstruo guardar(@RequestBody Monstruo usuarioGuardar){
        return  monstruosService.setItem(usuarioGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        monstruosService.deleteByID(id);
    }
}
