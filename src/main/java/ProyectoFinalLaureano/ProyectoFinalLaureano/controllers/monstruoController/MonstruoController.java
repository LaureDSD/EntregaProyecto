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
    public List<MonstruoDTO> obtenerListaMonstruos() {
        return conversorListaMonstruoDTO(monstruosService.getAll());
    }

    @GetMapping("/{id}")
    public MonstruoDTO obtenerMonstruo(@PathVariable Long id) {
        return conversorMonstruoDTO(monstruosService.getByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarMonstruo(@PathVariable Long id, @RequestBody Monstruo monstruoActualizar) {
        if (monstruoActualizar.getMonstruoId().equals(id)) {
            return ResponseEntity.ok(conversorMonstruoDTO(monstruosService.setItem(monstruoActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del monstruo.");
        }
    }

    @PostMapping
    public MonstruoDTO guardarMonstruo(@RequestBody Monstruo monstruoGuardar) {
        return conversorMonstruoDTO(monstruosService.setItem(monstruoGuardar));
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
        monstruoDTO.setId(m.getMonstruoId());
        monstruoDTO.setImagen(m.getImagen());
        monstruoDTO.setNombre(m.getNombre());
        monstruoDTO.setDescripcion(m.getDescripcion());
        monstruoDTO.setAlmas(m.getAlmasOtrogadas());
        monstruoDTO.setExperiencia(m.getExperienciaOtorgada());
        monstruoDTO.setEstadisticas(m.getEstadisticas());
        monstruoDTO.setDrops(conversorListaDropsDTO(m.getDrops()));
        return monstruoDTO;
    }

    //Conversor Lista
    public static List<DropsDTO> conversorListaDropsDTO(List<DropsObjetos> l){
            return l.stream().map(MonstruoController::conversorDropsDTO).toList();
    }


    //Conversor unico drops
    private static DropsDTO conversorDropsDTO(DropsObjetos dropsObjetos) {
        DropsDTO dropsDTO = new DropsDTO();
        dropsDTO.setItem(dropsObjetos.getItem());
        dropsDTO.setProbabilidad(dropsDTO.getProbabilidad());
        return dropsDTO;
    }


}