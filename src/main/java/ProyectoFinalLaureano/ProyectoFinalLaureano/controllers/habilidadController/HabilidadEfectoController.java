package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.HabilidadEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabildadEfectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidadEfecto")
public class HabilidadEfectoController {

    @Autowired
    private HabildadEfectoService habilidadEfectoService;

    //CRUD basico HabilidadEfecto

    @GetMapping("")
    public List<HabilidadEfecto> obtenerEfectos() {
        return habilidadEfectoService.getAll();
    }


    @GetMapping("/{habilidad_efecto_id}")
    public HabilidadEfecto obtenerEfectos(@PathVariable Long id) {
         return habilidadEfectoService.getByID(id);
    }


    @PutMapping("/{habilidad_efecto_id}")
    public ResponseEntity<Object> actualizarEfecto(@PathVariable Long id,  @RequestBody HabilidadEfecto efectoActualizar) {
        if(efectoActualizar.getHabilidad_efecto_id().equals(id)) {
            return ResponseEntity.ok( habilidadEfectoService.setItem(efectoActualizar) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del mapa.");
        }
    }

    @PostMapping("")
    public HabilidadEfecto guardarEfecto(@RequestBody HabilidadEfecto efectoGuardar) {
        return habilidadEfectoService.setItem(efectoGuardar);
    }

    @DeleteMapping("/{habilidad_efecto_id}")
    public void borrarEfecto( @PathVariable Long id) {
        habilidadEfectoService.deleteByID(id);
    }

}
