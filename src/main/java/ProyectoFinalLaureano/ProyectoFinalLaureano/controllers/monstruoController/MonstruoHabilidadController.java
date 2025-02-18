package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidadId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruoHabilidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monstruo")
@Tag(name = "MonstruoHabilidad", description = "API para gestionar habilidades de monstruos")
public class MonstruoHabilidadController {

    @Autowired
    private MonstruoHabilidadService monstruoHabilidadService;

    @GetMapping("/habilidad/")
    @Operation(summary = "Obtener todas las habilidades de monstruos")
    public List<MonstruoHabilidad> obtenerListaHabilidadesMonstruos() {
        return monstruoHabilidadService.getAll();
    }

    @GetMapping("/{monstruoId}/habilidad/")
    @Operation(summary = "Obtener todas las habilidades de un monstruo específico")
    public List<MonstruoHabilidad> obtenerListaHabilidadesMonstruo(@PathVariable Long monstruoId) {
        return monstruoHabilidadService.getByMonstruoId(monstruoId);
    }

    @GetMapping("/{monstruoId}/habilidad/{habilidadId}")
    @Operation(summary = "Obtener una habilidad específica de un monstruo")
    public MonstruoHabilidad obtenerHabilidadMonstruo(@PathVariable Long monstruoId, @PathVariable Long habilidadId) {
        return monstruoHabilidadService.getByID(new MonstruoHabilidadId(monstruoId, habilidadId));
    }

    @PutMapping("/{monstruoId}/habilidad/{habilidadId}")
    @Operation(summary = "Actualizar una habilidad de un monstruo")
    public ResponseEntity<Object> actualizarHabilidadMonstruo(@PathVariable Long monstruoId, @PathVariable Long habilidadId, @RequestBody MonstruoHabilidad habilidadActualizar) {
        if (habilidadActualizar.getId().equals(new MonstruoHabilidadId(monstruoId, habilidadId))) {
            return ResponseEntity.ok(monstruoHabilidadService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la habilidad.");
        }
    }

    @PostMapping("/{monstruoId}/habilidad/")
    @Operation(summary = "Crear una nueva habilidad para un monstruo")
    public MonstruoHabilidad guardarHabilidadMonstruo(@RequestBody MonstruoHabilidad habilidadGuardar) {
        return monstruoHabilidadService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{monstruoId}/habilidad/{habilidadId}")
    @Operation(summary = "Eliminar una habilidad de un monstruo")
    public void borrarHabilidadMonstruo(@PathVariable Long monstruoId, @PathVariable Long habilidadId) {
        monstruoHabilidadService.deleteByID(new MonstruoHabilidadId(monstruoId, habilidadId));
    }
}