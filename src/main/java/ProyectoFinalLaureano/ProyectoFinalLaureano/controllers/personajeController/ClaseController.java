package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController.EstadisticasController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.ClasePersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.ClaseDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.ClasePersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/personaje")
public class ClaseController {

    @Autowired
    private ClasePersonajeService clasePersonajeService;

    // CRUD CLASE PERSONAJE

    @GetMapping("/clase/")
    public List<ClaseDTO> obtenerListaClasesPersonaje() {
        return conversorListaClaseDTO(clasePersonajeService.getAll());
    }

    @GetMapping("/clase/{id}")
    public ClaseDTO obtenerClasePersonaje(@PathVariable Long id) {
        return conversorClaseDTO(clasePersonajeService.getByID(id));
    }

    @PutMapping("/clase/{id}")
    public ResponseEntity<Object> actualizarClasePersonaje(@PathVariable Long id, @RequestBody ClasePersonaje clasePersonajeActualizar) {
        if (clasePersonajeActualizar.getClase_id().equals(id)) {
            return ResponseEntity.ok( conversorClaseDTO(clasePersonajeService.setItem(clasePersonajeActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de la clase de personaje.");
        }
    }

    @PostMapping("/clase")
    public ClaseDTO guardarClasePersonaje(@RequestBody ClasePersonaje clasePersonajeGuardar) {
        return conversorClaseDTO(clasePersonajeService.setItem(clasePersonajeGuardar));
    }

    @DeleteMapping("/clase/{id}")
    public void borrarClasePersonaje(@PathVariable Long id) {
        clasePersonajeService.deleteByID(id);
    }

    //Conversor Lista
    public static List<ClaseDTO> conversorListaClaseDTO(List<ClasePersonaje> l){
        return l.stream().map(ClaseController::conversorClaseDTO).toList();
    }


    //Conversor Unico DTO
    public static ClaseDTO conversorClaseDTO(ClasePersonaje c){
        ClaseDTO claseDTO= new ClaseDTO();
        claseDTO.setId(c.getClase_id());
        claseDTO.setNombre(c.getNombre());
        claseDTO.setDescripcion(c.getDescripcion());
        claseDTO.setImagen(c.getImagen());
        claseDTO.setEstadisticas(EstadisticasController.conversorEstadisticasDTO(c.getEstadisticas()));
        return  claseDTO;
    }
}
