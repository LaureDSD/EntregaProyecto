package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.estadisticasService.EstadisticasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
@Tag(name = "EstadisticasGenerales", description = "API para gestionar estadísticas generales")
public class EstadisticasController {

    @Autowired
    private EstadisticasService estadisticasService;

    @GetMapping("/")
    @Operation(summary = "Obtener todas las estadísticas generales")
    public List<EstadisticasGenerales> obtenerUsuario(){
        return estadisticasService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una estadística general por ID")
    public EstadisticasGenerales obtener(@PathVariable Long id){
        return estadisticasService.getByID(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una estadística general por ID")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody EstadisticasGenerales estadisticaActualizar){
        if(estadisticaActualizar.getEstadistica_id().equals(id)) {
            return ResponseEntity.ok(estadisticasService.setItem(estadisticaActualizar));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de las estadísticas.");
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear una nueva estadística general")
    public EstadisticasGenerales guardar(@RequestBody EstadisticasGenerales estadisticasGuardar){
        return estadisticasService.setItem(estadisticasGuardar);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una estadística general por ID")
    public void borrar(@PathVariable Long id){
        estadisticasService.deleteByID(id);
    }
}