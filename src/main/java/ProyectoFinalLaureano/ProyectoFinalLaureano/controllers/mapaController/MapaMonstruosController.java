package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaMonstruoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapa")
@Tag(name = "MapaMonstruo", description = "API para gestionar monstruos en mapas")
public class MapaMonstruosController {

    @Autowired
    private MapaMonstruoService mapaMonstruoService;

    @GetMapping("/monstruo/")
    @Operation(summary = "Obtener todos los monstruos de todos los mapas")
    public List<MapaMonstruo> obtenerListaMonstruoMapas() {
        return mapaMonstruoService.getAll();
    }

    @GetMapping("{mapaId}/monstruo/")
    @Operation(summary = "Obtener todos los monstruos de un mapa específico")
    public List<MapaMonstruo> obtenerListaMonstruoMapa(@PathVariable Long id_mapa) {
        return mapaMonstruoService.getByMapaId(id_mapa);
    }

    @GetMapping("{mapaId}/monstruo/{monstruoId}")
    @Operation(summary = "Obtener un monstruo específico de un mapa")
    public MapaMonstruo obtenerMonstruoMapa(@PathVariable Long mapaId, @PathVariable Long monstruoId) {
        return mapaMonstruoService.getByID(new MapaMonstruoId(mapaId, monstruoId));
    }

    @PutMapping("{mapaId}/monstruo/{monstruoId}")
    @Operation(summary = "Actualizar un monstruo de un mapa")
    public ResponseEntity<Object> actualizarMonstruoMapa(@PathVariable Long id_mapa, @PathVariable Long id_monstruo, @RequestBody MapaMonstruo monstruoActualizar) {
        if (monstruoActualizar.getId().equals(new MapaMonstruoId(id_mapa, id_monstruo))) {
            return ResponseEntity.ok(mapaMonstruoService.setItem(monstruoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del monstruo.");
        }
    }

    @PostMapping("{mapaId}/monstruo/")
    @Operation(summary = "Crear un nuevo monstruo en un mapa")
    public MapaMonstruo guardarMonstruoMapa(@RequestBody MapaMonstruo monstruoGuardar) {
        return mapaMonstruoService.setItem(monstruoGuardar);
    }

    @DeleteMapping("{mapaId}/monstruo/{monstruoId}")
    @Operation(summary = "Eliminar un monstruo de un mapa")
    public void borrarMonstruoMapa(@PathVariable Long id_mapa, @PathVariable Long id_monstruo) {
        mapaMonstruoService.deleteByID(new MapaMonstruoId(id_mapa, id_monstruo));
    }
}