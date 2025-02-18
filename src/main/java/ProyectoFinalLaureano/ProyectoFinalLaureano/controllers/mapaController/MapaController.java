package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapa")
@Tag(name = "Mapa", description = "API para gestionar mapas")
public class MapaController {

    @Autowired
    private MapaService mapaService;

    @GetMapping("/")
    @Operation(summary = "Obtener todos los mapas o filtrar por tipo de mapa")
    public List<Mapa> obtenerListaMapas(@RequestParam(required = false) Long id) {
        if (id == null) {
            return mapaService.getAll();
        } else {
            TipoMapa tipoMapa = new TipoMapa();
            tipoMapa.setTipoMapaId(id);
            return mapaService.getBytipoMapa(tipoMapa);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un mapa por ID")
    public Mapa obtenerMapa(@PathVariable Long id) {
        return mapaService.getByID(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un mapa por ID")
    public ResponseEntity<Object> actualizarMapa(@PathVariable Long id, @RequestBody Mapa mapaActualizar) {
        if (mapaActualizar.getMapaId().equals(id)) {
            return ResponseEntity.ok(mapaService.setItem(mapaActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del mapa.");
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo mapa")
    public Mapa guardarMapa(@RequestBody Mapa mapaGuardar) {
        return mapaService.setItem(mapaGuardar);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un mapa por ID")
    public void borrarMapa(@PathVariable Long id) {
        mapaService.deleteByID(id);
    }
}