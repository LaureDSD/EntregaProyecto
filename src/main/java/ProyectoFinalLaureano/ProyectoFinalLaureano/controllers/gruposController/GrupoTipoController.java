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
@RequestMapping("/api/grupos")
@Tag(name = "TipoGrupo", description = "API para gestionar tipos de grupos")
public class GrupoTipoController {

    @Autowired
    private TipoGrupoService tipoGrupoService;

    @GetMapping("/tipo/")
    @Operation(summary = "Obtener todos los tipos de grupos")
    public List<TipoGrupo> obtener() {
        return tipoGrupoService.getAll();
    }

    @GetMapping("/tipo/{id}")
    @Operation(summary = "Obtener un tipo de grupo por ID")
    public TipoGrupo obtener(@PathVariable Long id) {
        return tipoGrupoService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    @Operation(summary = "Actualizar un tipo de grupo por ID")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody TipoGrupo habilidadActualizar) {
        if (habilidadActualizar.getTipoGrupoId().equals(id)) {
            return ResponseEntity.ok(tipoGrupoService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de grupo.");
        }
    }

    @PostMapping("/tipo")
    @Operation(summary = "Crear un nuevo tipo de grupo")
    public TipoGrupo guardar(@RequestBody TipoGrupo habilidadGuardar) {
        return tipoGrupoService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    @Operation(summary = "Eliminar un tipo de grupo por ID")
    public void borrar(@PathVariable Long id) {
        tipoGrupoService.deleteByID(id);
    }
}