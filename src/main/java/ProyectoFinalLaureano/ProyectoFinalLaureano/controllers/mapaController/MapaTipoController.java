package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.TipoMapaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapa")
@Tag(name = "TipoMapa", description = "API para gestionar tipos de mapas")
public class MapaTipoController {

    @Autowired
    private TipoMapaService tipoMapaService;

    @GetMapping("/tipo/")
    @Operation(summary = "Obtener todos los tipos de mapas")
    public List<TipoMapa> obtenerListaTipoMapa() {
        return tipoMapaService.getAll();
    }

    @GetMapping("/tipo/{id}")
    @Operation(summary = "Obtener un tipo de mapa por ID")
    public TipoMapa obtenerTipoMapa(@PathVariable Long id) {
        return tipoMapaService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    @Operation(summary = "Actualizar un tipo de mapa por ID")
    public ResponseEntity<Object> actualizarTipoMapa(@PathVariable Long id, @RequestBody TipoMapa tipoMapaActualizar) {
        if (tipoMapaActualizar.getTipoMapaId().equals(id)) {
            return ResponseEntity.ok(tipoMapaService.setItem(tipoMapaActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del mapa.");
        }
    }

    @PostMapping("/tipo")
    @Operation(summary = "Crear un nuevo tipo de mapa")
    public TipoMapa guardarTipoMapa(@RequestBody TipoMapa tipoMapaGuardar) {
        return tipoMapaService.setItem(tipoMapaGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    @Operation(summary = "Eliminar un tipo de mapa por ID")
    public void borrarTipoMapa(@PathVariable Long id) {
        tipoMapaService.deleteByID(id);
    }
}