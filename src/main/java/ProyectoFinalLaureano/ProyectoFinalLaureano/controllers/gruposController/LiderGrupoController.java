package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.LiderGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.LiderGrupoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lidergrupo")
@Tag(name = "LiderGrupo", description = "API para gestionar líderes de grupos")
public class LiderGrupoController {

    @Autowired
    private LiderGrupoService liderGrupoService;

    /**
     * Obtener todos los líderes de grupos.
     *
     * @return Lista de todos los líderes de grupos.
     */
    @GetMapping
    @Operation(summary = "Obtener todos los líderes de grupos")
    public ResponseEntity<?> getAllLiderGrupo() {
        try {
            List<LiderGrupo> lideres = liderGrupoService.findAll();
            return ResponseEntity.ok(lideres);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los líderes de grupos: " + e.getMessage());
        }
    }

    /**
     * Obtener un líder de grupo por su ID.
     *
     * @param id el ID del líder de grupo a obtener.
     * @return ResponseEntity con el líder de grupo o un mensaje de error si no se encuentra.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un líder de grupo por ID")
    public ResponseEntity<?> getLiderGrupoById(@PathVariable Long id) {
        try {
            Optional<LiderGrupo> liderGrupo = liderGrupoService.findById(id);
            if (liderGrupo.isPresent()) {
                return ResponseEntity.ok(liderGrupo.get());
            } else {
                return ResponseEntity.status(404).body("Líder de grupo no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el líder de grupo: " + e.getMessage());
        }
    }

    /**
     * Crear un nuevo líder de grupo.
     *
     * @param liderGrupo el líder de grupo a crear.
     * @return ResponseEntity con el líder de grupo creado.
     */
    @PostMapping
    @Operation(summary = "Crear un nuevo líder de grupo")
    public ResponseEntity<?> createLiderGrupo(@RequestBody LiderGrupo liderGrupo) {
        try {
            LiderGrupo nuevoLider = liderGrupoService.save(liderGrupo);
            return ResponseEntity.status(201).body(nuevoLider);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el líder de grupo: " + e.getMessage());
        }
    }

    /**
     * Eliminar un líder de grupo por su ID.
     *
     * @param id el ID del líder de grupo a eliminar.
     * @return ResponseEntity con un mensaje de éxito o error.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un líder de grupo por ID")
    public ResponseEntity<?> deleteLiderGrupo(@PathVariable Long id) {
        try {
            liderGrupoService.deleteById(id);
            return ResponseEntity.ok("Líder de grupo eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el líder de grupo: " + e.getMessage());
        }
    }
}
