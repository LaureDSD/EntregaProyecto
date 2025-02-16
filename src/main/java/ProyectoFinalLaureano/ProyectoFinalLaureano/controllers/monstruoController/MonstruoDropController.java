package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.drops.DropsObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.drops.DropsObjetosId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidadId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.DropsObjetosService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruoHabilidadService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.TipoMonstruoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monstruo")
public class MonstruoDropController {

    @Autowired
    private DropsObjetosService dropsObjetosService;

    // CRUD DROPS OBJETOS

    @GetMapping("/{monstruoId}/drop/")
    public List<DropsObjetos> obtenerListaDropsObjetos() {
        return dropsObjetosService.getAll();
    }

    @GetMapping("/{monstruoId}/drop/{dropId}")
    public DropsObjetos obtenerDropObjeto(@PathVariable Long monstruoId, @PathVariable Long dropId) {
        return dropsObjetosService.getByID(new DropsObjetosId(monstruoId,dropId));
    }

    @PutMapping("/{monstruoId}/drop/{dropId}")
    public ResponseEntity<Object> actualizarDropObjeto(@PathVariable Long monstruoId, @PathVariable Long dropId, @RequestBody DropsObjetos dropActualizar) {
        if (dropActualizar.getId().equals(new DropsObjetosId(monstruoId, dropId))) {
            return ResponseEntity.ok(dropsObjetosService.setItem(dropActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del drop.");
        }
    }

    @PostMapping("/{monstruoId}/drop/")
    public DropsObjetos guardarDropObjeto(@RequestBody DropsObjetos dropGuardar) {
        return dropsObjetosService.setItem(dropGuardar);
    }

    @DeleteMapping("/{monstruoId}/drop/{dropId}")
    public void borrarDropObjeto(@PathVariable Long monstruoId, @PathVariable Long dropId) {
        dropsObjetosService.deleteByID(new DropsObjetosId(monstruoId, dropId));
    }
}