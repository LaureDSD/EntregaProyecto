package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController.EfectoEstadoController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController.EstadisticasController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController.MonstruoController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.efectoEstado.HabilidadEfecto;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.ObjetivoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.habilidadDTO.HabilidadDTO;

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
    public List<HabilidadDTO> obtenerLista(@RequestParam(required = false) TipoHabilidad tipoHabilidad,
                                        @RequestParam(required = false) ObjetivoHabilidad objetivoHabilidad){
        if(tipoHabilidad==null && objetivoHabilidad==null){
            return  conversorListaHabilidadDTO(habilidadService.getAll());
        }else{
            return conversorListaHabilidadDTO(habilidadService.buscarHabilidades(tipoHabilidad, objetivoHabilidad));
        }
    }

    @GetMapping("/{id}")
    public HabilidadDTO obtenerHabilidad(@PathVariable Long id){
        return conversorHabilidadDTO(habilidadService.getByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidadActualizar){
        if(habilidadActualizar.getHabilidad_id().equals(id)) {
            return ResponseEntity.ok( conversorHabilidadDTO(habilidadService.setItem(habilidadActualizar)) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del mapa.");
        }
    }

    @PostMapping
    public HabilidadDTO guardarHabilidad(@RequestBody Habilidad habilidadGuardar){
        return  conversorHabilidadDTO(habilidadService.setItem(habilidadGuardar));
    }

    @DeleteMapping("/{id}")
    public void borrarHabilidad (@PathVariable Long id){
        habilidadService.deleteByID(id);
    }


    //Conversor Lista habilidad
    public static List<HabilidadDTO> conversorListaHabilidadDTO(List<Habilidad> hl){
        return hl.stream().map(HabilidadController::conversorHabilidadDTO).toList();
    }

    //Combersor unico hablidad
    public static HabilidadDTO conversorHabilidadDTO (Habilidad o){
        HabilidadDTO hdto = new HabilidadDTO();
        hdto.setId(o.getHabilidad_id());
        hdto.setImagen(o.getImagen());
        hdto.setNombre(o.getNombre());
        hdto.setDescripcion(o.getDescripcion());
        hdto.setRequisito_nivel(o.getRequisito_nivel());
        hdto.setNivel_maximo(o.getNivel_maximo());
        hdto.setTipoHabilidad(o.getTipoHabilidad());
        hdto.setObjetivoHabilidad(o.getObjetivoHabilidad());
        hdto.setArea(o.getArea_efecto());
        hdto.setUnidades(o.getUnidades_afectadas());
        hdto.setEnfriamiento(o.getEnfriamiento());
        hdto.setEstadisticas(EstadisticasController.conversorEstadisticasDTO(o.getEstadisticas()));
        hdto.setEfectos(EfectoEstadoController.conversorListaEstadoDTO(
                o.getEfectos().stream().map(HabilidadEfecto::getEfecto).toList()));
        return  hdto;
    }

}
