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
public class MonstruoHabilidadController {

    @Autowired
    private MonstruoHabilidadService monstruoHabilidadService;

    // CRUD MONSTRUO HABILIDAD
    @GetMapping("/habilidad/")
    public List<MonstruoHabilidad> obtenerListaHabilidadesMonstruos() {
        return monstruoHabilidadService.getAll();
    }

    /*
    @GetMapping("/{monstruoId}/habilidad/")
    public List<MonstruoHabilidad> obtenerListaHabilidadesMonstruo(@PathVariable Long monstruoId) {
        return monstruoHabilidadService.getByMonstruoId(monstruoId);
    }*/

    @GetMapping("/{monstruoId}/habilidad/{habilidadId}")
    public MonstruoHabilidad obtenerHabilidadMonstruo(@PathVariable Long monstruoId, @PathVariable Long habilidadId) {
        return monstruoHabilidadService.getByID(new MonstruoHabilidadId(monstruoId, habilidadId));
    }

    @PutMapping("/{monstruoId}/habilidad/{habilidadId}")
    public ResponseEntity<Object> actualizarHabilidadMonstruo(@PathVariable Long monstruoId, @PathVariable Long habilidadId, @RequestBody MonstruoHabilidad habilidadActualizar) {
        if (habilidadActualizar.getId().equals(new MonstruoHabilidadId(monstruoId, habilidadId))) {
            return ResponseEntity.ok(monstruoHabilidadService.setItem(habilidadActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la habilidad.");
        }
    }

    @PostMapping("/{monstruoId}/habilidad/")
    public MonstruoHabilidad guardarHabilidadMonstruo(@RequestBody MonstruoHabilidad habilidadGuardar) {
        return monstruoHabilidadService.setItem(habilidadGuardar);
    }

    @DeleteMapping("/{monstruoId}/habilidad/{habilidadId}")
    public void borrarHabilidadMonstruo(@PathVariable Long monstruoId, @PathVariable Long habilidadId) {
        monstruoHabilidadService.deleteByID(new MonstruoHabilidadId(monstruoId, habilidadId));
    }

}