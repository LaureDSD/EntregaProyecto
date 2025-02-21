package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.HabilidadEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService.HabilidadEfectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidadEfecto")
public class HabilidadEfectoController {

    @Autowired
    private HabilidadEfectoService habilidadEfectoService;

    /**
     * Obtener todos los efectos de habilidad.
     *
     * @return Lista de todos los efectos de habilidad.
     */
    @GetMapping("")
    public ResponseEntity<?> obtenerEfectos() {
        try {
            List<HabilidadEfecto> efectos = habilidadEfectoService.getAll();
            return ResponseEntity.ok(efectos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los efectos: " + e.getMessage());
        }
    }

    /**
     * Obtener un efecto de habilidad por su ID.
     *
     * @param id el ID del efecto de habilidad.
     * @return El efecto de habilidad o un mensaje de error si no se encuentra.
     */
    @GetMapping("/{habilidad_efecto_id}")
    public ResponseEntity<?> obtenerEfectos(@PathVariable Long id) {
        try {
            HabilidadEfecto habilidadEfecto = habilidadEfectoService.getByID(id);
            if (habilidadEfecto == null) {
                return ResponseEntity.status(404).body("Efecto de habilidad no encontrado con ID: " + id);
            }
            return ResponseEntity.ok(habilidadEfecto);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el efecto de habilidad: " + e.getMessage());
        }
    }

    /**
     * Actualizar un efecto de habilidad por su ID.
     *
     * @param id el ID del efecto de habilidad a actualizar.
     * @param efectoActualizar los nuevos datos del efecto de habilidad.
     * @return Respuesta con el efecto actualizado o un mensaje de error si los IDs no coinciden.
     */
    @PutMapping("/{habilidad_efecto_id}")
    public ResponseEntity<?> actualizarEfecto(@PathVariable Long id,  @RequestBody HabilidadEfecto efectoActualizar) {
        try {
            if(efectoActualizar.getHabilidad_efecto_id().equals(id)) {
                return ResponseEntity.ok(habilidadEfectoService.setItem(efectoActualizar));
            } else {
                return ResponseEntity.status(400).body("El ID proporcionado no coincide con el ID del efecto.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el efecto de habilidad: " + e.getMessage());
        }
    }

    /**
     * Crear un nuevo efecto de habilidad.
     *
     * @param efectoGuardar los datos del nuevo efecto de habilidad.
     * @return El efecto de habilidad creado.
     */
    @PostMapping("")
    public ResponseEntity<?> guardarEfecto(@RequestBody HabilidadEfecto efectoGuardar) {
        try {
            return ResponseEntity.status(201).body(habilidadEfectoService.setItem(efectoGuardar));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el efecto de habilidad: " + e.getMessage());
        }
    }

    /**
     * Eliminar un efecto de habilidad por su ID.
     *
     * @param id el ID del efecto de habilidad a eliminar.
     * @return Un mensaje de éxito o error.
     */
    @DeleteMapping("/{habilidad_efecto_id}")
    public ResponseEntity<?> borrarEfecto(@PathVariable Long id) {
        try {
            habilidadEfectoService.deleteByID(id);
            return ResponseEntity.ok("Efecto de habilidad eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el efecto de habilidad: " + e.getMessage());
        }
    }
}
