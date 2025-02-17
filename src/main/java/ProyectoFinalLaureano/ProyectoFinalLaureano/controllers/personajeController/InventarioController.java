package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController.ObjetoController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonajeId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.InventarioDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.InventarioPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/personaje")
public class InventarioController {

    @Autowired
    private InventarioPersonajeService inventarioPersonajeService;

    // CRUD INVENTARIO PERSONAJE

    @GetMapping("/inventario/")
    public List<InventarioDTO> obtenerListaInventarioPersonaje() {
        return conversorListaInventarioDTO(inventarioPersonajeService.getAll());
    }

    @GetMapping("/inventario/{personajeId}/{itemId}")
    public InventarioDTO obtenerInventarioPersonaje(@PathVariable Long personajeId, @PathVariable Long itemId) {
        return conversorInventarioDTO(inventarioPersonajeService.getByID(new InventarioPersonajeId(personajeId, itemId)));
    }

    @PutMapping("/inventario/{personajeId}/{itemId}")
    public ResponseEntity<Object> actualizarInventarioPersonaje(@PathVariable Long personajeId, @PathVariable Long itemId, @RequestBody InventarioPersonaje inventarioActualizar) {
        if (inventarioActualizar.getId().equals(new InventarioPersonajeId(personajeId, itemId))) {
            return ResponseEntity.ok(conversorInventarioDTO(inventarioPersonajeService.setItem(inventarioActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del inventario.");
        }
    }

    @PostMapping("/inventario/")
    public InventarioDTO guardarInventarioPersonaje(@RequestBody InventarioPersonaje inventarioGuardar) {
        return conversorInventarioDTO(inventarioPersonajeService.setItem(inventarioGuardar));
    }

    @DeleteMapping("/inventario/{personajeId}/{itemId}")
    public void borrarInventarioPersonaje(@PathVariable Long personajeId, @PathVariable Long itemId) {
        inventarioPersonajeService.deleteByID(new InventarioPersonajeId(personajeId, itemId));
    }

    //Conversor Lista
    public static List<InventarioDTO> conversorListaInventarioDTO(List<InventarioPersonaje> l){
        return l.stream().map(InventarioController::conversorInventarioDTO).toList();
    }

    private static InventarioDTO conversorInventarioDTO(InventarioPersonaje inventarioPersonaje) {
        InventarioDTO inventarioDTO = new InventarioDTO();
        inventarioDTO.setItem(ObjetoController.conversorItemDTO(inventarioPersonaje.getItem()));
        inventarioDTO.setCantidad(inventarioPersonaje.getCantidad());
        inventarioDTO.setFecha_obtencion(inventarioPersonaje.getFecha_obtencion());
        return inventarioDTO;
    }

}