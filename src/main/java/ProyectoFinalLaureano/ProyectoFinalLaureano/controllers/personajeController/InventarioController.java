package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.InventarioDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
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

    @Autowired
    private ItemService itemService;

    @GetMapping("/inventario/")
    @Operation(summary = "Obtener todos los inventarios de personajes")
    public List<InventarioDTO> obtenerListaInventarioPersonajes() {
        return conversorListaInventarioDTO(inventarioPersonajeService.getAll());
    }


    @GetMapping("/{personajeId}/inventario/{itemId}")
    @Operation(summary = "Obtener un ítem específico del inventario de un personaje")
    public InventarioDTO obtenerInventarioPersonaje(@PathVariable Long id) {
        return conversorInventarioDTO(inventarioPersonajeService.getByID(id));
    }

    @PutMapping("/{personajeId}/inventario/{itemId}")
    @Operation(summary = "Actualizar un ítem en el inventario de un personaje")
    public ResponseEntity<Object> actualizarInventarioPersonaje(@PathVariable Long id, @RequestBody InventarioPersonaje inventarioActualizar) {
        if (inventarioActualizar.getPersonaje_inventario_id().equals(id)) {
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
    public void borrarInventarioPersonaje(@PathVariable Long id) {
        inventarioPersonajeService.deleteByID(id);
    }

    // Conversor Lista
    public  List<InventarioDTO> conversorListaInventarioDTO(List<InventarioPersonaje> l) {
        return l.stream().map(this::conversorInventarioDTO).toList();
    }

    // Conversor Unico
    private  InventarioDTO conversorInventarioDTO(InventarioPersonaje inventarioPersonaje) {
        InventarioDTO inventarioDTO = new InventarioDTO();
        inventarioDTO.setItem( inventarioPersonaje.getItem());
        inventarioDTO.setCantidad(inventarioPersonaje.getCantidad());
        inventarioDTO.setFecha_obtencion(inventarioPersonaje.getFecha_obtencion());
        return inventarioDTO;
    }
}