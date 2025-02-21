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

    /**
     * Obtener todas las habilidades o filtrar por tipo y objetivo.
     *
     * @param tipoHabilidad el tipo de habilidad para filtrar (opcional).
     * @param objetivoHabilidad el objetivo de la habilidad para filtrar (opcional).
     * @return Lista de habilidades filtradas o todas las habilidades.
     */
    @GetMapping("/")
    @Operation(summary = "Obtener todas las habilidades o filtrar por tipo y objetivo")
    public ResponseEntity<?> obtenerLista(@RequestParam(required = false) TipoHabilidad tipoHabilidad,
                                          @RequestParam(required = false) ObjetivoHabilidad objetivoHabilidad) {
        try {
            if (tipoHabilidad == null && objetivoHabilidad == null) {
                return ResponseEntity.ok(habilidadService.getAll());
            } else {
                return ResponseEntity.ok(habilidadService.buscarHabilidades(tipoHabilidad, objetivoHabilidad));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener las habilidades: " + e.getMessage());
        }
    }

    /**
     * Obtener una habilidad por su ID.
     *
     * @param id el ID de la habilidad a obtener.
     * @return ResponseEntity con la habilidad encontrada o un mensaje de error.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtener una habilidad por ID")
    public ResponseEntity<?> obtenerHabilidad(@PathVariable Long id) {
        try {
            Habilidad habilidad = habilidadService.getByID(id);
            if (habilidad == null) {
                return ResponseEntity.status(404).body("Habilidad no encontrada con ID: " + id);
            }
            return ResponseEntity.ok(habilidad);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener la habilidad: " + e.getMessage());
        }
    }

    /**
     * Actualizar una habilidad por su ID.
     *
     * @param id el ID de la habilidad a actualizar.
     * @param habilidadActualizar el objeto con los nuevos datos de la habilidad.
     * @return ResponseEntity con la habilidad actualizada o un mensaje de error si los IDs no coinciden.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una habilidad por ID")
    public ResponseEntity<?> actualizarHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidadActualizar) {
        try {
            if (habilidadActualizar.getHabilidad_id().equals(id)) {
                return ResponseEntity.ok(habilidadService.setItem(habilidadActualizar));
            } else {
                return ResponseEntity.status(400).body("El ID proporcionado no coincide con el ID de la habilidad.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar la habilidad: " + e.getMessage());
        }
    }

    /**
     * Crear una nueva habilidad.
     *
     * @param habilidadGuardar el objeto con los datos de la nueva habilidad.
     * @return ResponseEntity con la habilidad creada.
     */
    @PostMapping
    @Operation(summary = "Crear una nueva habilidad")
    public ResponseEntity<?> guardarHabilidad(@RequestBody Habilidad habilidadGuardar) {
        try {
            return ResponseEntity.status(201).body(habilidadService.setItem(habilidadGuardar));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear la habilidad: " + e.getMessage());
        }
    }

    /**
     * Eliminar una habilidad por su ID.
     *
     * @param id el ID de la habilidad a eliminar.
     * @return ResponseEntity con un mensaje de éxito o error.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una habilidad por ID")
    public ResponseEntity<?> borrarHabilidad(@PathVariable Long id) {
        try {
            habilidadService.deleteByID(id);
            return ResponseEntity.ok("Habilidad eliminada con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar la habilidad: " + e.getMessage());
        }
    }
}
