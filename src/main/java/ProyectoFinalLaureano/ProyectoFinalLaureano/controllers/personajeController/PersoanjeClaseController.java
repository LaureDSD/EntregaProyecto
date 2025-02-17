package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.ClasePersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.ClaseDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.ClasePersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/personaje")
public class PersoanjeClaseController {

    @Autowired
    private ClasePersonajeService clasePersonajeService;

    // CRUD CLASE PERSONAJE

    @GetMapping("/clase/")
    public List<ClasePersonaje> obtenerListaClasesPersonaje() {
        return clasePersonajeService.getAll();
    }

    @GetMapping("/clase/{id}")
    public ClasePersonaje obtenerClasePersonaje(@PathVariable Long id) {
        return clasePersonajeService.getByID(id);
    }

    @PutMapping("/clase/{id}")
    public ResponseEntity<Object> actualizarClasePersonaje(@PathVariable Long id, @RequestBody ClasePersonaje clasePersonajeActualizar) {
        if (clasePersonajeActualizar.getClase_id().equals(id)) {
            return ResponseEntity.ok(clasePersonajeService.setItem(clasePersonajeActualizar));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la clase de personaje.");
        }
    }

    @PostMapping("/clase")
    public ClasePersonaje guardarClasePersonaje(@RequestBody ClasePersonaje clasePersonajeGuardar) {
        return clasePersonajeService.setItem(clasePersonajeGuardar);
    }

    @DeleteMapping("/clase/{id}")
    public void borrarClasePersonaje(@PathVariable Long id) {
        clasePersonajeService.deleteByID(id);
    }

    //Conversor Lista
    public static List<ClaseDTO> conversorListaClaseDTO(List<ClasePersonaje> l){
        return l.stream().map(PersoanjeClaseController::conversorClaseDTO).toList();
    }


    //Conversor Unico DTO
    public static ClaseDTO conversorClaseDTO(ClasePersonaje c){
        ClaseDTO claseDTO= new ClaseDTO();

        return  claseDTO;
    }
}
