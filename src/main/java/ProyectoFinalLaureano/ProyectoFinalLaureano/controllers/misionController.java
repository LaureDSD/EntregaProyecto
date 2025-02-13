package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mision")
public class misionController {

    @Autowired
    private MisionService misionService;

    @GetMapping("/")
    public List<Mision> obtenerUsuario(){
        return  misionService.getAll();
    }

    @GetMapping("/{id}")
    public Mision obtener(@PathVariable Long id){
        return misionService.getByID(id);
    }

    @PutMapping("/{id}")
    public  Mision actualizar(@PathVariable Long id, @RequestBody Mision misionActualizar){
        misionActualizar.setMision_id(id);
        return  misionService.setItem(misionActualizar);
    }

    @PostMapping
    public Mision guardar(@RequestBody Mision misionGuardar){
        return  misionService.setItem(misionGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        misionService.deleteByID(id);
    }
}
