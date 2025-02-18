package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.efectosEstados.MapaEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaEfectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapa")
@Tag(name = "MapaEfecto", description = "API para gestionar efectos en mapas")
public class MapaEfectoController {

    @Autowired
    private MapaEfectoService mapaEfectoService;

    @GetMapping("/efecto/")
    @Operation(summary = "Obtener todos los efectos de todos los mapas")
    public List<MapaEfecto> obtenerListaEfectoMapas() {
        return mapaEfectoService.getAll();
    }

    @GetMapping("/{mapaId}/efecto/")
    @Operation(summary = "Obtener todos los efectos de un mapa específico")
    public List<MapaEfecto> obtenerListaEfectoMapa(@PathVariable Long mapaId) {
        return mapaEfectoService.getByMapaId(mapaId);
    }

    @GetMapping("/{mapaId}/efecto/{efectoId}")
    @Operation(summary = "Obtener un efecto específico de un mapa")
    public MapaEfecto obtenerEfectoMapa(@PathVariable Long mapaId, @PathVariable Long efectoId) {
        return mapaEfectoService.getByID(new MapaEfectoId(mapaId, efectoId));
    }

    @PutMapping("/{mapaId}/efecto/{efectoId}")
    @Operation(summary = "Actualizar un efecto de un mapa")
    public ResponseEntity<Object> actualizarEfectoMapa(
            @PathVariable Long mapaId,
            @PathVariable Long efectoId,
            @RequestBody MapaEfecto efectoActualizar) {
        if (efectoActualizar.getId().equals(new MapaEfectoId(mapaId, efectoId))) {
            return ResponseEntity.ok(mapaEfectoService.setItem(efectoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del efecto.");
        }
    }

    @PostMapping("/{mapaId}/efecto/")
    @Operation(summary = "Crear un nuevo efecto en un mapa")
    public MapaEfecto guardarEfectoMapa(@PathVariable Long mapaId, @RequestBody MapaEfecto efectoGuardar) {
        efectoGuardar.setId(new MapaEfectoId(mapaId, efectoGuardar.getId().getEfecto_id()));
        return mapaEfectoService.setItem(efectoGuardar);
    }

    @DeleteMapping("/{mapaId}/efecto/{efectoId}")
    @Operation(summary = "Eliminar un efecto de un mapa")
    public void borrarEfectoMapa(@PathVariable Long mapaId, @PathVariable Long efectoId) {
        mapaEfectoService.deleteByID(new MapaEfectoId(mapaId, efectoId));
    }
}