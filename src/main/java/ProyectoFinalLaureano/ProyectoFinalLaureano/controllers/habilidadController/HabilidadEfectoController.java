package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.ObjetivoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabildadEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadEfectoController {

    @Autowired
    private HabildadEfectoService habilidadEfectoService;

    //CRUD basico HabilidadEfecto

    @GetMapping("/{habilidadId}/efecto/")
    public List<HabilidadEfecto> obtenerEfectos() {
        return habilidadEfectoService.getAll();
    }

    /*
    @GetMapping("/{habilidadId}/efecto/")
    public List<HabilidadEfecto> obtenerEfectos(@PathVariable Long habilidadId) {
        return habilidadEfectoService.getByHabilidadId();
    }*/

    @GetMapping("/{habilidadId}/efecto/{efectoId}")
    public HabilidadEfecto obtenerEfecto(@PathVariable Long habilidadId, @PathVariable Long efectoId) {
        return habilidadEfectoService.getByID(new HabilidadEfectoId(habilidadId, efectoId));
    }

    @PutMapping("/{habilidadId}/efecto/{efectoId}")
    public ResponseEntity<Object> actualizarEfecto(@PathVariable Long habilidadId, @PathVariable Long efectoId, @RequestBody HabilidadEfecto efectoActualizar) {
        if(efectoActualizar.getId().equals(new HabilidadEfectoId(habilidadId,efectoId))) {
            return ResponseEntity.ok( habilidadEfectoService.setItem(efectoActualizar) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del mapa.");
        }
    }

    @PostMapping("/{habilidadId}/efecto/")
    public HabilidadEfecto guardarEfecto(@RequestBody HabilidadEfecto efectoGuardar) {
        return habilidadEfectoService.setItem(efectoGuardar);
    }

    @DeleteMapping("/{habilidadId}/efecto/{efectoId}")
    public void borrarEfecto(@PathVariable Long habilidadId, @PathVariable Long efectoId) {
        habilidadEfectoService.deleteByID(new HabilidadEfectoId(habilidadId, efectoId));
    }

}
