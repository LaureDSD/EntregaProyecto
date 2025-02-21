package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@Tag(name = "Grupo", description = "API para gestionar grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    /**
     * Obtener todos los grupos o filtrar por tipo de grupo.
     *
     * @param tipoGrupoId el ID del tipo de grupo para filtrar (opcional)
     * @return ResponseEntity con la lista de grupos o un mensaje de error.
     */
    @GetMapping("/")
    @Operation(summary = "Obtener todos los grupos o filtrar por tipo de grupo")
    public ResponseEntity<?> obtenerLista(@RequestParam(required = false) Long tipoGrupoId) {
        try {
            if (tipoGrupoId == null) {
                return ResponseEntity.ok(grupoService.getAll());
            } else {
                TipoGrupo tg = new TipoGrupo();
                tg.setTipoGrupoId(tipoGrupoId);
                List<Grupo> grupos = grupoService.getBytipoGrupo(tg);
                if (grupos.isEmpty()) {
                    return ResponseEntity.status(404).body("No se encontraron grupos para el tipo de grupo con ID: " + tipoGrupoId);
                }
                return ResponseEntity.ok(grupos);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los grupos: " + e.getMessage());
        }
    }

    /**
     * Obtener un grupo por su ID.
     *
     * @param id el ID del grupo a obtener.
     * @return ResponseEntity con el grupo o un mensaje de error si no se encuentra.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un grupo por ID")
    public ResponseEntity<?> obtenerGrupo(@PathVariable Long id) {
        try {
            Grupo grupo = grupoService.getByID(id);
            if (grupo == null) {
                return ResponseEntity.status(404).body("Grupo no encontrado con ID: " + id);
            }
            return ResponseEntity.ok(grupo);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el grupo: " + e.getMessage());
        }
    }

    /**
     * Actualizar un grupo por su ID.
     *
     * @param id el ID del grupo a actualizar.
     * @param grupoActualizar el grupo con los datos nuevos a actualizar.
     * @return ResponseEntity con el grupo actualizado o un mensaje de error.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un grupo por ID")
    public ResponseEntity<?> actualizarGrupo(@PathVariable Long id, @RequestBody Grupo grupoActualizar) {
        try {
            if (!grupoActualizar.getGrupoId().equals(id)) {
                return ResponseEntity.status(400).body("El ID proporcionado no coincide con el ID del grupo.");
            }
            Grupo grupoActualizado = grupoService.setItem(grupoActualizar);
            return ResponseEntity.ok(grupoActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el grupo: " + e.getMessage());
        }
    }

    /**
     * Crear un nuevo grupo.
     *
     * @param grupoGuardar el grupo a crear.
     * @return ResponseEntity con el nuevo grupo o un mensaje de error.
     */
    @PostMapping
    @Operation(summary = "Crear un nuevo grupo")
    public ResponseEntity<?> guardarGrupo(@RequestBody Grupo grupoGuardar) {
        try {
            Grupo grupoNuevo = grupoService.setItem(grupoGuardar);
            return ResponseEntity.status(201).body(grupoNuevo);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el grupo: " + e.getMessage());
        }
    }

    /**
     * Eliminar un grupo por su ID.
     *
     * @param id el ID del grupo a eliminar.
     * @return ResponseEntity con un mensaje de éxito o error.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un grupo por ID")
    public ResponseEntity<?> borrarGrupo(@PathVariable Long id) {
        try {
            grupoService.deleteByID(id);
            return ResponseEntity.ok("Grupo eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el grupo: " + e.getMessage());
        }
    }
}
