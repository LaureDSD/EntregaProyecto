package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.ObjetivoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;
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
    private HabildadEfectoService habilidadEfectoService;

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
    public  Habilidad actualizarHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidadActualizar){
        habilidadActualizar.setHabilidad_id(id);
        return  habilidadService.setItem(habilidadActualizar);
    }

    @PostMapping
    public Habilidad guardarHabilidad(@RequestBody Habilidad habilidadGuardar){
        return  habilidadService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrarHabilidad (@PathVariable Long id){
        habilidadService.deleteByID(id);
    }





    //CRUD basico HabilidadEfecto


    @GetMapping("/{habilidadId}/efecto/")
    public List<HabilidadEfecto> obtenerEfectos() {
        return habilidadEfectoService.getAll();
    }

    @GetMapping("/{habilidadId}/efecto/{efectoId}")
    public HabilidadEfecto obtenerEfecto(@PathVariable Long habilidadId, @PathVariable Long efectoId) {
        return habilidadEfectoService.getByID(new HabilidadEfectoId(habilidadId, efectoId));
    }

    @PutMapping("/{habilidadId}/efecto/{efectoId}")
    public HabilidadEfecto actualizarEfecto(@PathVariable Long habilidadId, @PathVariable Long efectoId, @RequestBody HabilidadEfecto efectoActualizar) {
        efectoActualizar.setId(new HabilidadEfectoId(habilidadId,efectoId));
        return habilidadEfectoService.setItem(efectoActualizar);
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
