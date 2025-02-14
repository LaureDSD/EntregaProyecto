package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Gremio;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GremioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GruposController {

    @Autowired
    private GremioService gremioService;

    @Autowired
    private GrupoService grupoService;

    @GetMapping("/")
    public List<Gremio> obtenerUsuario(){
        return  gremioService.getAll();
    }

    @GetMapping("/{id}")
    public Gremio obtener(@PathVariable Long id){
        return gremioService.getByID(id);
    }

    @PutMapping("/{id}")
    public  Gremio actualizar(@PathVariable Long id, @RequestBody Gremio habilidadActualizar){
        habilidadActualizar.setGremio_id(id);
        return  gremioService.setItem(habilidadActualizar);
    }

    @PostMapping
    public Gremio guardar(@RequestBody Gremio habilidadGuardar){
        return  gremioService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        gremioService.deleteByID(id);
    }
}
