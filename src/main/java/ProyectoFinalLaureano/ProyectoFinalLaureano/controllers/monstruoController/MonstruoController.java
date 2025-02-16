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

    @Autowired
    private MonstruoHabilidadService monstruoHabilidadService;

    @Autowired
    private DropsObjetosService dropsObjetosService;

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

    // CRUD MONSTRUO HABILIDAD

    @GetMapping("/{monstruoId}/habilidad/")
    public List<MonstruoHabilidad> obtenerListaHabilidadesMonstruo() {
        return monstruoHabilidadService.getAll();
    }

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