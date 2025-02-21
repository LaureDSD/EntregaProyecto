package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaEfectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapaEfecto")
@Tag(name = "MapaEfecto", description = "API para gestionar efectos en mapas")
public class MapaEfectoController {

    @Autowired
    private MapaEfectoService mapaEfectoService;

    @GetMapping("")
    @Operation(summary = "Obtener todos los efectos de todos los mapas")
    public List<MapaEfecto> obtenerListaEfectoMapas() {
        return mapaEfectoService.getAll();
    }


    @GetMapping("/{mapa_efecto_id}")
    @Operation(summary = "Obtener un efecto específico de un mapa")
    public MapaEfecto obtenerEfectoMapa(@PathVariable Long id) {
        return mapaEfectoService.getByID(id);
    }

    @PutMapping("/{mapa_efecto_id}")
    @Operation(summary = "Actualizar un efecto de un mapa")
    public ResponseEntity<Object> actualizarEfectoMapa(
            @PathVariable Long id,
            @RequestBody MapaEfecto efectoActualizar) {
        if (efectoActualizar.getMapa_efecto_id().equals(id)) {
            return ResponseEntity.ok(mapaEfectoService.setItem(efectoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del efecto.");
        }
    }

    @PostMapping("/{mapa_efecto_id}")
    @Operation(summary = "Crear un nuevo efecto en un mapa")
    public MapaEfecto guardarEfectoMapa(@PathVariable Long id, @RequestBody MapaEfecto efectoGuardar) {
        efectoGuardar.setMapa_efecto_id(id);
        return mapaEfectoService.setItem(efectoGuardar);
    }

    @DeleteMapping("/{mapa_efecto_id}")
    @Operation(summary = "Eliminar un efecto de un mapa")
    public void borrarEfectoMapa(@PathVariable Long mapaId, @PathVariable Long id) {
        mapaEfectoService.deleteByID(id);
    }
}