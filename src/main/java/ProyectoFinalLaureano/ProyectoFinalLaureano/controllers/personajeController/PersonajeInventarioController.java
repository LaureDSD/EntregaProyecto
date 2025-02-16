package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonajeId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.InventarioPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/personaje")
public class PersonajeInventarioController {

    @Autowired
    private InventarioPersonajeService inventarioPersonajeService;

    // CRUD INVENTARIO PERSONAJE

    @GetMapping("/inventario/")
    public List<InventarioPersonaje> obtenerListaInventarioPersonaje() {
        return inventarioPersonajeService.getAll();
    }

    @GetMapping("/inventario/{personajeId}/{itemId}")
    public InventarioPersonaje obtenerInventarioPersonaje(@PathVariable Long personajeId, @PathVariable Long itemId) {
        return inventarioPersonajeService.getByID(new InventarioPersonajeId(personajeId, itemId));
    }

    @PutMapping("/inventario/{personajeId}/{itemId}")
    public ResponseEntity<Object> actualizarInventarioPersonaje(@PathVariable Long personajeId, @PathVariable Long itemId, @RequestBody InventarioPersonaje inventarioActualizar) {
        if (inventarioActualizar.getId().equals(new InventarioPersonajeId(personajeId, itemId))) {
            return ResponseEntity.ok(inventarioPersonajeService.setItem(inventarioActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del inventario.");
        }
    }

    @PostMapping("/inventario/")
    public InventarioPersonaje guardarInventarioPersonaje(@RequestBody InventarioPersonaje inventarioGuardar) {
        return inventarioPersonajeService.setItem(inventarioGuardar);
    }

    @DeleteMapping("/inventario/{personajeId}/{itemId}")
    public void borrarInventarioPersonaje(@PathVariable Long personajeId, @PathVariable Long itemId) {
        inventarioPersonajeService.deleteByID(new InventarioPersonajeId(personajeId, itemId));
    }
}