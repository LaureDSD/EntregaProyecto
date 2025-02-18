package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.misionController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.npcController.NPCController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.Mision;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mision.recompensas.MisionObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO.MisionDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.misionDTO.RecompensaDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.misionService.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mision")
public class MisionController {

    @Autowired
    private MisionService misionService;

    //CRUD MSISIONES
    @GetMapping("/")
    public List<MisionDTO> obtenerMisones(){
        return  conversorListaMisionDTO(misionService.getAll());
    }

    @GetMapping("/{id}")
    public MisionDTO obtenerMisones(@PathVariable Long id){
        return conversorMisionDTO(misionService.getByID(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> actualizarMisones(@PathVariable Long id, @RequestBody Mision misionActualizar){
        if(misionActualizar.getMision_id().equals(id)) {
            return ResponseEntity.ok( conversorMisionDTO(misionService.setItem(misionActualizar)));
        }else{
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la mision.");
        }
    }

    @PostMapping
    public MisionDTO guardarMisones(@RequestBody Mision misionGuardar){
        return  conversorMisionDTO(misionService.setItem(misionGuardar));
    }

    @DeleteMapping("/{id}")
    public void borrarMisones (@PathVariable Long id){
        misionService.deleteByID(id);
    }

    //Conversor Lista
    public static List<MisionDTO> conversorListaMisionDTO(List<Mision> l){
        return l.stream().map(MisionController::conversorMisionDTO).toList();
    }

    //Conversor Unico DTO
    public static MisionDTO conversorMisionDTO( Mision m){
        MisionDTO misionDTO = new MisionDTO();
        misionDTO.setId(m.getMision_id());
        misionDTO.setNombre(m.getNombre());
        misionDTO.setDescripcion(m.getDescripcion());
        misionDTO.setNivel(m.getNivel_minimo());
        misionDTO.setTiempo(m.getTiempo_limite());
        misionDTO.setAlmas(m.getRecompensa_almas());
        misionDTO.setExperiencia(m.getRecompensa_experiencia());
        misionDTO.setRecompensas(
                m.getRecompensas().stream().map(MisionController::conversorRecompensaDTO).toList());
        return misionDTO;
    }


    //Conversro lista
    public static List<RecompensaDTO> converosrListaRecompensaDTO(List<MisionObjetos> ms){
        return ms.stream().map(MisionController::conversorRecompensaDTO).toList();
    }

    //Coversor Unico
    public static RecompensaDTO conversorRecompensaDTO(MisionObjetos mo){
        RecompensaDTO recompensaDTO = new RecompensaDTO();
        recompensaDTO.setItem(mo.getItem());
        recompensaDTO.setCantidad(mo.getCantidad());
        return recompensaDTO;
    }

}
