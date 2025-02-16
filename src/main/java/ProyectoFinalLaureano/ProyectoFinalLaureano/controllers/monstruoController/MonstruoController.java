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
public class MonstruoController {

    @Autowired
    private MonstruosService monstruosService;


    // CRUD MONSTRUO

    @GetMapping("/")
    public List<Monstruo> obtenerListaMonstruos() {
        return monstruosService.getAll();
    }

    @GetMapping("/{id}")
    public Monstruo obtenerMonstruo(@PathVariable Long id) {
        return monstruosService.getByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarMonstruo(@PathVariable Long id, @RequestBody Monstruo monstruoActualizar) {
        if (monstruoActualizar.getMonstruo_id().equals(id)) {
            return ResponseEntity.ok(monstruosService.setItem(monstruoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del monstruo.");
        }
    }

    @PostMapping
    public Monstruo guardarMonstruo(@RequestBody Monstruo monstruoGuardar) {
        return monstruosService.setItem(monstruoGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrarMonstruo(@PathVariable Long id) {
        monstruosService.deleteByID(id);
    }

}