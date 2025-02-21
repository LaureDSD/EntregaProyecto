package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.efectoEstadoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/efectos")
@Tag(name = "EfectoEstado", description = "API para gestionar efectos de estado")
public class EfectoEstadoController {

    @Autowired
    private EfectoEstadoService efectoEstadoService;

    /**
     * Obtener todos los efectos de estado.
     *
     * @return Lista de todos los efectos de estado.
     */
    @GetMapping("/")
    @Operation(summary = "Obtener todos los efectos de estado")
    public ResponseEntity<?> obtenerUsuario() {
        try {
            return ResponseEntity.ok(efectoEstadoService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los efectos de estado: " + e.getMessage());
        }
    }

    /**
     * Obtener un efecto de estado por su ID.
     *
     * @param id el ID del efecto de estado a obtener.
     * @return ResponseEntity con el efecto de estado o un mensaje de error si no se encuentra.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un efecto de estado por ID")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        try {
            EfectoEstado efectoEstado = efectoEstadoService.getByID(id);
            if (efectoEstado == null) {
                return ResponseEntity.status(404).body("Efecto de estado no encontrado con ID: " + id);
            }
            return ResponseEntity.ok(efectoEstado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el efecto de estado: " + e.getMessage());
        }
    }

    /**
     * Actualizar un efecto de estado por su ID.
     *
     * @param id el ID del efecto de estado a actualizar.
     * @param efectoEstadoActualizar el objeto con los nuevos datos del efecto de estado.
     * @return ResponseEntity con el efecto de estado actualizado o un mensaje de error si los IDs no coinciden.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un efecto de estado por ID")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody EfectoEstado efectoEstadoActualizar) {
        try {
            if (efectoEstadoActualizar.getEfecto_id().equals(id)) {
                return ResponseEntity.ok(efectoEstadoService.setItem(efectoEstadoActualizar));
            } else {
                return ResponseEntity.status(400).body("El ID proporcionado no coincide con el ID del efecto.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el efecto de estado: " + e.getMessage());
        }
    }

    /**
     * Crear un nuevo efecto de estado.
     *
     * @param EfectoEstadoGuardar el objeto con los datos del nuevo efecto de estado a crear.
     * @return ResponseEntity con el efecto de estado creado.
     */
    @PostMapping
    @Operation(summary = "Crear un nuevo efecto de estado")
    public ResponseEntity<?> guardar(@RequestBody EfectoEstado EfectoEstadoGuardar) {
        try {
            return ResponseEntity.ok(efectoEstadoService.setItem(EfectoEstadoGuardar));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el efecto de estado: " + e.getMessage());
        }
    }

    /**
     * Eliminar un efecto de estado por su ID.
     *
     * @param id el ID del efecto de estado a eliminar.
     * @return ResponseEntity con un mensaje de éxito o error.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un efecto de estado por ID")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        try {
            efectoEstadoService.deleteByID(id);
            return ResponseEntity.ok("Efecto de estado eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el efecto de estado: " + e.getMessage());
        }
    }
}
