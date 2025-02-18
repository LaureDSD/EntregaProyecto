package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.objetoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService.ItemEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService.TipoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objeto")
public class ObjetoTipoController {

    @Autowired
    private TipoItemService tipoItemService;

    // CRUD TIPO ITEM

    @GetMapping("/tipo/")
    public List<TipoItem> obtenerListaTiposItem() {
        return tipoItemService.getAll();
    }

    @GetMapping("/tipo/{id}")
    public TipoItem obtenerTipoItem(@PathVariable Long id) {
        return tipoItemService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    public ResponseEntity<Object> actualizarTipoItem(@PathVariable Long id, @RequestBody TipoItem tipoItemActualizar) {
        if (tipoItemActualizar.getTipoItemId().equals(id)) {
            return ResponseEntity.ok(tipoItemService.setItem(tipoItemActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de ítem.");
        }
    }

    @PostMapping("/tipo")
    public TipoItem guardarTipoItem(@RequestBody TipoItem tipoItemGuardar) {
        return tipoItemService.setItem(tipoItemGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    public void borrarTipoItem(@PathVariable Long id) {
        tipoItemService.deleteByID(id);
    }

}