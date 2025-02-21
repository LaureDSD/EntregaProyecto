package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.TipoGrupoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoGrupo")
@Tag(name = "TipoGrupo", description = "API para gestionar tipos de grupos")
public class GrupoTipoController {

    @Autowired
    private TipoGrupoService tipoGrupoService;

    /**
     * Obtener todos los tipos de grupos.
     *
     * @return Listado de todos los tipos de grupos.
     */
    @GetMapping("/")
    @Operation(summary = "Obtener todos los tipos de grupos")
    public ResponseEntity<?> obtener() {
        try {
            List<TipoGrupo> tiposGrupos = tipoGrupoService.getAll();
            return ResponseEntity.ok(tiposGrupos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los tipos de grupos: " + e.getMessage());
        }
    }

    /**
     * Obtener un tipo de grupo por ID.
     *
     * @param id el ID del tipo de grupo a obtener.
     * @return ResponseEntity con el tipo de grupo o un mensaje de error si no se encuentra.
     */
    @GetMapping("{id}")
    @Operation(summary = "Obtener un tipo de grupo por ID")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        try {
            TipoGrupo tipoGrupo = tipoGrupoService.getByID(id);
            if (tipoGrupo == null) {
                return ResponseEntity.status(404).body("Tipo de grupo no encontrado con ID: " + id);
            }
            return ResponseEntity.ok(tipoGrupo);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el tipo de grupo: " + e.getMessage());
        }
    }

    /**
     * Actualizar un tipo de grupo por ID.
     *
     * @param id el ID del tipo de grupo a actualizar.
     * @param tipoGrupoActualizar el tipo de grupo con los nuevos datos a actualizar.
     * @return ResponseEntity con el tipo de grupo actualizado o un mensaje de error.
     */
    @PutMapping("{id}")
    @Operation(summary = "Actualizar un tipo de grupo por ID")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody TipoGrupo tipoGrupoActualizar) {
        try {
            if (tipoGrupoActualizar.getTipoGrupoId().equals(id)) {
                TipoGrupo tipoGrupoActualizado = tipoGrupoService.setItem(tipoGrupoActualizar);
                return ResponseEntity.ok(tipoGrupoActualizado);
            } else {
                return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de grupo.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el tipo de grupo: " + e.getMessage());
        }
    }

    /**
     * Crear un nuevo tipo de grupo.
     *
     * @param tipoGrupoGuardar el tipo de grupo a crear.
     * @return ResponseEntity con el nuevo tipo de grupo creado.
     */
    @PostMapping("")
    @Operation(summary = "Crear un nuevo tipo de grupo")
    public ResponseEntity<?> guardar(@RequestBody TipoGrupo tipoGrupoGuardar) {
        try {
            TipoGrupo tipoGrupoNuevo = tipoGrupoService.setItem(tipoGrupoGuardar);
            return ResponseEntity.status(201).body(tipoGrupoNuevo);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el tipo de grupo: " + e.getMessage());
        }
    }

    /**
     * Eliminar un tipo de grupo por ID.
     *
     * @param id el ID del tipo de grupo a eliminar.
     * @return ResponseEntity con un mensaje de éxito o error.
     */
    @DeleteMapping("{id}")
    @Operation(summary = "Eliminar un tipo de grupo por ID")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        try {
            tipoGrupoService.deleteByID(id);
            return ResponseEntity.ok("Tipo de grupo eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el tipo de grupo: " + e.getMessage());
        }
    }
}
