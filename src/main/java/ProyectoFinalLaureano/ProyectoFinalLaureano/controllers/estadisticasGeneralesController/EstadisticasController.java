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

    /**
     * Obtener todas las estadísticas generales.
     *
     * @return Lista de todas las estadísticas generales.
     */
    @GetMapping("/")
    @Operation(summary = "Obtener todas las estadísticas generales")
    public ResponseEntity<?> obtenerEstadisticas() {
        try {
            List<EstadisticasGenerales> estadisticas = estadisticasService.getAll();
            return ResponseEntity.ok(estadisticas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener las estadísticas: " + e.getMessage());
        }
    }

    /**
     * Obtener una estadística general por su ID.
     *
     * @param id el ID de la estadística general a obtener.
     * @return ResponseEntity con la estadística o un mensaje de error si no se encuentra.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtener una estadística general por ID")
    public ResponseEntity<?> obtenerEstadistica(@PathVariable Long id) {
        try {
            EstadisticasGenerales estadistica = estadisticasService.getByID(id);
            if (estadistica == null) {
                return ResponseEntity.status(404).body("Estadística no encontrada con ID: " + id);
            }
            return ResponseEntity.ok(estadistica);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener la estadística: " + e.getMessage());
        }
    }

    /**
     * Actualizar una estadística general por su ID.
     *
     * @param id el ID de la estadística a actualizar.
     * @param estadisticaActualizar el objeto con los nuevos datos de la estadística.
     * @return ResponseEntity con la estadística actualizada o un mensaje de error si el ID no coincide.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una estadística general por ID")
    public ResponseEntity<?> actualizarEstadistica(@PathVariable Long id, @RequestBody EstadisticasGenerales estadisticaActualizar) {
        try {
            if (!estadisticaActualizar.getEstadistica_id().equals(id)) {
                return ResponseEntity.status(400).body("El ID proporcionado no coincide con el ID de las estadísticas.");
            }
            return ResponseEntity.ok(estadisticasService.setItem(estadisticaActualizar));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar la estadística: " + e.getMessage());
        }
    }

    /**
     * Crear una nueva estadística general.
     *
     * @param estadisticasGuardar el objeto de la nueva estadística a guardar.
     * @return ResponseEntity con la estadística creada.
     */
    @PostMapping("/")
    @Operation(summary = "Crear una nueva estadística general")
    public ResponseEntity<?> guardarEstadistica(@RequestBody EstadisticasGenerales estadisticasGuardar) {
        try {
            EstadisticasGenerales nuevaEstadistica = estadisticasService.setItem(estadisticasGuardar);
            return ResponseEntity.status(201).body(nuevaEstadistica);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear la estadística: " + e.getMessage());
        }
    }

    /**
     * Eliminar una estadística general por su ID.
     *
     * @param id el ID de la estadística a eliminar.
     * @return ResponseEntity con un mensaje de éxito o error.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una estadística general por ID")
    public ResponseEntity<?> borrarEstadistica(@PathVariable Long id) {
        try {
            estadisticasService.deleteByID(id);
            return ResponseEntity.ok("Estadística eliminada con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar la estadística: " + e.getMessage());
        }
    }
}
