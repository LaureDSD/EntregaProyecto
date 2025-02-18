package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.gruposController;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.LiderGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.LiderGrupoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lidergrupo")
@Tag(name = "LiderGrupo", description = "API para gestionar líderes de grupos")
public class LiderGrupoController {

    @Autowired
    private LiderGrupoService liderGrupoService;

    @GetMapping
    @Operation(summary = "Obtener todos los líderes de grupos")
    public List<LiderGrupo> getAllLiderGrupo() {
        return liderGrupoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un líder de grupo por ID")
    public Optional<LiderGrupo> getLiderGrupoById(@PathVariable Long id) {
        return liderGrupoService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo líder de grupo")
    public LiderGrupo createLiderGrupo(@RequestBody LiderGrupo liderGrupo) {
        return liderGrupoService.save(liderGrupo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un líder de grupo por ID")
    public void deleteLiderGrupo(@PathVariable Long id) {
        liderGrupoService.deleteById(id);
    }
}