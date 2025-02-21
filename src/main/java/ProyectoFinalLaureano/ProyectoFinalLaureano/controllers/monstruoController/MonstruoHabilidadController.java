package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruoHabilidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monstruoHabilidad")
@Tag(name = "MonstruoHabilidad", description = "API para gestionar habilidades de monstruos")
public class MonstruoHabilidadController {

    @Autowired
    private MonstruoHabilidadService monstruoHabilidadService;

    @GetMapping("")
    @Operation(summary = "Obtener todas las habilidades de monstruos")
    public List<MonstruoHabilidad> obtenerListaHabilidadesMonstruos() {
        return monstruoHabilidadService.getAll();
    }


    @GetMapping("/{monstruo_habilidad_id}")
    @Operation(summary = "Obtener una habilidad específica de un monstruo")
    public MonstruoHabilidad obtenerHabilidadMonstruo(@PathVariable Long id) {
        return monstruoHabilidadService.getByID(id);
    }

    @PutMapping("/{monstruo_habilidad_id}")
    @Operation(summary = "Actualizar una habilidad de un monstruo")
    public ResponseEntity<Object> actualizarHabilidadMonstruo(@PathVariable Long id, @RequestBody MonstruoHabilidad habilidadActualizar) {
        if (habilidadActualizar.getMonstruo_habilidad_id().equals(id)) {
            return ResponseEntity.ok(monstruoHabilidadService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la habilidad.");
        }
    }

    @PostMapping("/{monstruo_habilidad_id}")
    @Operation(summary = "Crear una nueva habilidad para un monstruo")
    public MonstruoHabilidad guardarHabilidadMonstruo(@RequestBody MonstruoHabilidad habilidadGuardar) {
        return monstruoHabilidadService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{monstruo_habilidad_id}")
    @Operation(summary = "Eliminar una habilidad de un monstruo")
    public void borrarHabilidadMonstruo(@PathVariable Long id) {
        monstruoHabilidadService.deleteByID(id);
    }
}