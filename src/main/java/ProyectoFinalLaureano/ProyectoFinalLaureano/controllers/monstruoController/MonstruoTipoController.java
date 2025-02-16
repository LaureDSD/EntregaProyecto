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
public class MonstruoTipoController {

    @Autowired
    private TipoMonstruoService tipoMonstruoService;

    // CRUD TIPO MONSTRUO

    @GetMapping("/tipo/")
    public List<TipoMonstruo> obtenerListaTiposMonstruo() {
        return tipoMonstruoService.getAll();
    }

    @GetMapping("/tipo/{id}")
    public TipoMonstruo obtenerTipoMonstruo(@PathVariable Long id) {
        return tipoMonstruoService.getByID(id);
    }

    @PutMapping("/tipo/{id}")
    public ResponseEntity<Object> actualizarTipoMonstruo(@PathVariable Long id, @RequestBody TipoMonstruo tipoMonstruoActualizar) {
        if (tipoMonstruoActualizar.getTipo_monstruo_id().equals(id)) {
            return ResponseEntity.ok(tipoMonstruoService.setItem(tipoMonstruoActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del tipo de monstruo.");
        }
    }

    @PostMapping("/tipo")
    public TipoMonstruo guardarTipoMonstruo(@RequestBody TipoMonstruo tipoMonstruoGuardar) {
        return tipoMonstruoService.setItem(tipoMonstruoGuardar);
    }

    @DeleteMapping("/tipo/{id}")
    public void borrarTipoMonstruo(@PathVariable Long id) {
        tipoMonstruoService.deleteByID(id);
    }


}