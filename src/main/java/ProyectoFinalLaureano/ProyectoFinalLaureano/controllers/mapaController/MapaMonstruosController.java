package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaMonstruoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapaMonstruo")
@Tag(name = "MapaMonstruo", description = "API para gestionar monstruos en mapas")
public class MapaMonstruosController {

    @Autowired
    private MapaMonstruoService mapaMonstruoService;

    @GetMapping("")
    @Operation(summary = "Obtener todos los monstruos de todos los mapas")
    public List<MapaMonstruo> obtenerListaMonstruoMapas() {
        return mapaMonstruoService.getAll();
    }

    @GetMapping("{mapa_monstruo_id}")
    @Operation(summary = "Obtener un monstruo específico de un mapa")
    public MapaMonstruo obtenerMonstruoMapa(@PathVariable Long id) {
        return mapaMonstruoService.getByID(id);
    }

    @PutMapping("{mapa_monstruo_id}")
    @Operation(summary = "Actualizar un monstruo de un mapa")
    public ResponseEntity<Object> actualizarMonstruoMapa(@PathVariable Long id, @RequestBody MapaMonstruo monstruoActualizar) {
        if (monstruoActualizar.getMapa_monstruo_id().equals(id)) {
            return ResponseEntity.ok(mapaMonstruoService.setItem(monstruoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del monstruo.");
        }
    }

    @PostMapping("{mapa_monstruo_id}")
    @Operation(summary = "Crear un nuevo monstruo en un mapa")
    public MapaMonstruo guardarMonstruoMapa(@RequestBody MapaMonstruo monstruoGuardar) {
        return mapaMonstruoService.setItem(monstruoGuardar);
    }

    @DeleteMapping("{mapa_monstruo_id}")
    @Operation(summary = "Eliminar un monstruo de un mapa")
    public void borrarMonstruoMapa(@PathVariable Long id) {
        mapaMonstruoService.deleteByID(id);
    }
}