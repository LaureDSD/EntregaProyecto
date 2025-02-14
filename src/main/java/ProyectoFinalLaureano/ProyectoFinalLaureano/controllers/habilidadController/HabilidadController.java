package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabildadEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    @Autowired
    private HabildadEfectoService habildadEfectoService;

    @GetMapping("/")
    public List<Habilidad> obtenerUsuario(){
        return  habilidadService.getAll();
    }

    @GetMapping("/{id}")
    public Habilidad obtener(@PathVariable Long id){
        return habilidadService.getByID(id);
    }

    @PutMapping("/{id}")
    public  Habilidad actualizar(@PathVariable Long id, @RequestBody Habilidad habilidadActualizar){
        habilidadActualizar.setHabilidad_id(id);
        return  habilidadService.setItem(habilidadActualizar);
    }

    @PostMapping
    public Habilidad guardar(@RequestBody Habilidad habilidadGuardar){
        return  habilidadService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        habilidadService.deleteByID(id);
    }
}
