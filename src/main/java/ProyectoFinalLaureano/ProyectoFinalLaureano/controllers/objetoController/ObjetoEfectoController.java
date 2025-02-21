package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemEfectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objetoEfecto")
@Tag(name = "ObjetoEfecto", description = "API para gestionar efectos de objetos (ítems)")
public class ObjetoEfectoController {

    @Autowired
    private ItemEfectoService itemEfectoService;

    @GetMapping("")
    @Operation(summary = "Obtener todos los efectos de ítems")
    public List<ItemEfecto> obtenerListaEfectosItems() {
        return itemEfectoService.getAll();
    }


    @GetMapping("/{objeto_efecto_id}")
    @Operation(summary = "Obtener un efecto específico de un ítem")
    public ItemEfecto obtenerEfectoItem(@PathVariable Long id) {
        return itemEfectoService.getByID(id);
    }

    @PutMapping("/{objeto_efecto_id}")
    @Operation(summary = "Actualizar un efecto de un ítem")
    public ResponseEntity<Object> actualizarEfectoItem(@PathVariable Long id, @RequestBody ItemEfecto efectoActualizar) {
        if (efectoActualizar.getItem_efecto_id().equals(id)) {
            return ResponseEntity.ok(itemEfectoService.setItem(efectoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del efecto.");
        }
    }

    @PostMapping("/{objeto_efecto_id}")
    @Operation(summary = "Crear un nuevo efecto para un ítem")
    public ItemEfecto guardarEfectoItem(@RequestBody ItemEfecto efectoGuardar) {
        return itemEfectoService.setItem(efectoGuardar);
    }

    @DeleteMapping("/{objeto_efecto_id}")
    @Operation(summary = "Eliminar un efecto de un ítem")
    public void borrarEfectoItem(@PathVariable Long id) {
        itemEfectoService.deleteByID(id);
    }

}