package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonajeId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.InventarioDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.InventarioPersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
@Tag(name = "InventarioPersonaje", description = "API para gestionar el inventario de personajes")
public class InventarioController {

    @Autowired
    private InventarioPersonajeService inventarioPersonajeService;

    @GetMapping("/inventario/")
    @Operation(summary = "Obtener todos los inventarios de personajes")
    public List<InventarioDTO> obtenerListaInventarioPersonajes() {
        return conversorListaInventarioDTO(inventarioPersonajeService.getAll());
    }

    @GetMapping("/inventario/{personajeId}")
    @Operation(summary = "Obtener el inventario de un personaje específico")
    public List<InventarioDTO> obtenerListaInventarioPersonaje(@PathVariable Long personajeId) {
        return conversorListaInventarioDTO(inventarioPersonajeService.getByPersonajeId(personajeId));
    }

    @GetMapping("/{personajeId}/inventario/{itemId}")
    @Operation(summary = "Obtener un ítem específico del inventario de un personaje")
    public InventarioDTO obtenerInventarioPersonaje(@PathVariable Long personajeId, @PathVariable Long itemId) {
        return conversorInventarioDTO(inventarioPersonajeService.getByID(new InventarioPersonajeId(personajeId, itemId)));
    }

    @PutMapping("/{personajeId}/inventario/{itemId}")
    @Operation(summary = "Actualizar un ítem en el inventario de un personaje")
    public ResponseEntity<Object> actualizarInventarioPersonaje(@PathVariable Long personajeId, @PathVariable Long itemId, @RequestBody InventarioPersonaje inventarioActualizar) {
        if (inventarioActualizar.getId().equals(new InventarioPersonajeId(personajeId, itemId))) {
            return ResponseEntity.ok(conversorInventarioDTO(inventarioPersonajeService.setItem(inventarioActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del inventario.");
        }
    }

    @PostMapping("/inventario/")
    @Operation(summary = "Crear un nuevo ítem en el inventario de un personaje")
    public InventarioDTO guardarInventarioPersonaje(@RequestBody InventarioPersonaje inventarioGuardar) {
        return conversorInventarioDTO(inventarioPersonajeService.setItem(inventarioGuardar));
    }

    @DeleteMapping("/{personajeId}/inventario/{itemId}")
    @Operation(summary = "Eliminar un ítem del inventario de un personaje")
    public void borrarInventarioPersonaje(@PathVariable Long personajeId, @PathVariable Long itemId) {
        inventarioPersonajeService.deleteByID(new InventarioPersonajeId(personajeId, itemId));
    }

    // Conversor Lista
    public static List<InventarioDTO> conversorListaInventarioDTO(List<InventarioPersonaje> l) {
        return l.stream().map(InventarioController::conversorInventarioDTO).toList();
    }

    // Conversor Unico
    private static InventarioDTO conversorInventarioDTO(InventarioPersonaje inventarioPersonaje) {
        InventarioDTO inventarioDTO = new InventarioDTO();
        inventarioDTO.setItem(inventarioPersonaje.getItem());
        inventarioDTO.setCantidad(inventarioPersonaje.getCantidad());
        inventarioDTO.setFecha_obtencion(inventarioPersonaje.getFecha_obtencion());
        return inventarioDTO;
    }
}