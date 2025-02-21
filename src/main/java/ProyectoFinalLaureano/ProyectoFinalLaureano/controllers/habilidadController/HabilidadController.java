package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.Habilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.ObjetivoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.enums.TipoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
@Tag(name = "Habilidad", description = "API para gestionar habilidades")
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    @GetMapping("/")
    @Operation(summary = "Obtener todas las habilidades o filtrar por tipo y objetivo")
    public List<Habilidad> obtenerLista(@RequestParam(required = false) TipoHabilidad tipoHabilidad,
                                        @RequestParam(required = false) ObjetivoHabilidad objetivoHabilidad) {
        if (tipoHabilidad == null && objetivoHabilidad == null) {
            return habilidadService.getAll();
        } else {
            return habilidadService.buscarHabilidades(tipoHabilidad, objetivoHabilidad);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una habilidad por ID")
    public Habilidad obtenerHabilidad(@PathVariable Long id) {
        return habilidadService.getByID(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una habilidad por ID")
    public ResponseEntity<Object> actualizarHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidadActualizar) {
        if (habilidadActualizar.getHabilidad_id().equals(id)) {
            return ResponseEntity.ok(habilidadService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la habilidad.");
        }
    }

    @PostMapping
    @Operation(summary = "Crear una nueva habilidad")
    public Habilidad guardarHabilidad(@RequestBody Habilidad habilidadGuardar) {
        return habilidadService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una habilidad por ID")
    public void borrarHabilidad(@PathVariable Long id) {
        habilidadService.deleteByID(id);
    }
}