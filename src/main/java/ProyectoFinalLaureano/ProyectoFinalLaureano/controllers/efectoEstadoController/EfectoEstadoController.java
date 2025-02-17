package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController.EstadisticasController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.efectosDTO.EfectoDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/efectos")
public class EfectoEstadoController {

    @Autowired
    private EfectoEstadoService efectoEstadoService;

    @GetMapping("/")
    public List<EfectoDTO> obtenerUsuario(){
        return  conversorListaEstadoDTO(efectoEstadoService.getAll());
    }

    @GetMapping("/{id}")
    public EfectoDTO obtener(@PathVariable Long id){
        return conversorEstadoDTO(efectoEstadoService.getByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody EfectoEstado efectoEstadoActualizar){
        if(efectoEstadoActualizar.getEfecto_id().equals(id)) {
            return ResponseEntity.ok( conversorEstadoDTO(efectoEstadoService.setItem(efectoEstadoActualizar)) );
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del efecto.");
        }
    }

    @PostMapping
    public EfectoDTO guardar(@RequestBody EfectoEstado EfectoEstadoGuardar){
        return  conversorEstadoDTO(efectoEstadoService.setItem(EfectoEstadoGuardar));
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        efectoEstadoService.deleteByID(id);
    }



    //Conversor lista estados
    public static List<EfectoDTO> conversorListaEstadoDTO (List<EfectoEstado> le){
        List<EfectoDTO> leDTO = new ArrayList<>();
        le.forEach(e -> leDTO.add(conversorEstadoDTO(e)) );
        return leDTO;
    }

    //Conversor Unico DTO Estado
    public static EfectoDTO conversorEstadoDTO (EfectoEstado e){
        EfectoDTO efectoDTO = new EfectoDTO();
        efectoDTO.setId(e.getEfecto_id());
        efectoDTO.setIcono(e.getImagen_icono());
        efectoDTO.setNombre(e.getNombre());
        efectoDTO.setDescripcion(e.getDescripcion());
        efectoDTO.setTipo(e.getTipo());
        efectoDTO.setObjetivo(e.getTipo_afectado());
        efectoDTO.setDuracion(e.getDuracion_efecto());
        efectoDTO.setAcumulaciones(e.getAcumulaciones());
        efectoDTO.setEstadisticas(EstadisticasController.conversorEstadisticasDTO(e.getEstadisticas()));
        return efectoDTO;
    }
}
