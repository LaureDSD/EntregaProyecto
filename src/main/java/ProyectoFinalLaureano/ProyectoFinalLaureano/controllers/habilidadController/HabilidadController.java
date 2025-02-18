package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController.EfectoEstadoController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController.EstadisticasController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfecto;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.ObjetivoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;

import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    //CRUD Habilidades

    //Pasando ( GET /habilidades/buscar?tipoHabilidad=OFENSIVA&objetivoHabilidad=ENEMIGO )
    @GetMapping("/")
    public List<Habilidad> obtenerLista(@RequestParam(required = false) TipoHabilidad tipoHabilidad,
                                        @RequestParam(required = false) ObjetivoHabilidad objetivoHabilidad){
        if(tipoHabilidad==null && objetivoHabilidad==null){
            return  habilidadService.getAll();
        }else{
            return habilidadService.buscarHabilidades(tipoHabilidad, objetivoHabilidad);
        }
    }

    @GetMapping("/{id}")
    public Habilidad obtenerHabilidad(@PathVariable Long id){
        return habilidadService.getByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidadActualizar){
        if(habilidadActualizar.getHabilidadId().equals(id)) {
            return ResponseEntity.ok( habilidadService.setItem(habilidadActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del mapa.");
        }
    }

    @PostMapping
    public Habilidad guardarHabilidad(@RequestBody Habilidad habilidadGuardar){
        return  habilidadService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrarHabilidad (@PathVariable Long id){
        habilidadService.deleteByID(id);
    }


}
