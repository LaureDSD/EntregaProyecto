package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.estadisticasService.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstaditicasController {

    @Autowired
    private EstadisticasService estadisticasService;

    //CRUD basico de Tipos
    @GetMapping("/")
    public List<EstadisticasGenerales> obtenerUsuario(){
        return  estadisticasService.getAll();
    }

    @GetMapping("/{id}")
    public EstadisticasGenerales obtener(@PathVariable Long id){
        return estadisticasService.getByID(id);
    }

    @PutMapping("/{id}")
    public  EstadisticasGenerales actualizar(@PathVariable Long id, @RequestBody EstadisticasGenerales estadisticaActualizar){
        estadisticaActualizar.setEstadisticasId(id);
        return  estadisticasService.setItem(estadisticaActualizar);
    }

    @PostMapping("/")
    public EstadisticasGenerales guardar(@RequestBody EstadisticasGenerales estadisticasGuardar){
        return  estadisticasService.setItem(estadisticasGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        estadisticasService.deleteByID(id);
    }
}
