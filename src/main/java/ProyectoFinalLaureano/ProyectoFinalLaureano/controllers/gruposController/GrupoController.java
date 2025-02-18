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

    @GetMapping("/")
    @Operation(summary = "Obtener todos los grupos o filtrar por tipo de grupo")
    public List<Grupo> obtenerLista(@RequestParam(required = false) Long id) {
        if (id == null) {
            return grupoService.getAll();
        } else {
            TipoGrupo tg = new TipoGrupo();
            tg.setTipoGrupoId(id);
            return grupoService.getBytipoGrupo(tg);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un grupo por ID")
    public Grupo obtenerGrupo(@PathVariable Long id) {
        return grupoService.getByID(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un grupo por ID")
    public ResponseEntity<Object> actualizarGrupo(@PathVariable Long id, @RequestBody Grupo habilidadActualizar) {
        if (habilidadActualizar.getGrupoId().equals(id)) {
            return ResponseEntity.ok(grupoService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del grupo.");
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo grupo")
    public Grupo guardarGrupo(@RequestBody Grupo habilidadGuardar) {
        return grupoService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un grupo por ID")
    public void borrarGrupo(@PathVariable Long id) {
        grupoService.deleteByID(id);
    }
}