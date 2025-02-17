package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController.EstadisticasController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController.HabilidadController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.drops.DropsObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.habilidades.MonstruoHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO.DropsDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO.MonstruoDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
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

    //Conversor Lista
    public static List<MonstruoDTO> conversorListaMonstruoDTO(List<Monstruo> l){
        return l.stream().map(MonstruoController::conversorMonstruoDTO).toList();
    }


    //Conversor Unico DTO
    public static MonstruoDTO conversorMonstruoDTO(Monstruo m){
        MonstruoDTO monstruoDTO = new MonstruoDTO();
        monstruoDTO.setId(m.getMonstruo_id());
        monstruoDTO.setImagen(m.getImagen());
        monstruoDTO.setNombre(m.getNombre());
        monstruoDTO.setDescripcion(m.getDescripcion());
        monstruoDTO.setAlmas(m.getAlmasOtrogadas());
        monstruoDTO.setExperiencia(m.getExperienciaOtorgada());
        monstruoDTO.setEstadisticas(EstadisticasController.conversorEstadisticasDTO(m.getEstadisticas()));
        monstruoDTO.setDrops(m.getDrops());
        monstruoDTO.setHabilidades(
                HabilidadController.conversorListaHabilidadDTO(
                        m.getMonstruoHabilidades().stream().map(MonstruoHabilidad::getHabilidad).toList()));
        return monstruoDTO;
    }

    //Conversor Lista
    public static List<DropsDTO> conversorListaDropsDTO(List<DropsObjetos> l){
            return l.stream().map(MonstruoController::conversorDropsDTO).toList();
    }


    //Conversor unico drops
    private static DropsDTO conversorDropsDTO(DropsObjetos dropsObjetos) {
        return null;
    }


}