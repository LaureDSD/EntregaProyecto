package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.personajeDTO.PersonajeDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pesonaje")
public class PersonajeController {

    @Autowired
    private PersoanjeService persoanjeService;

    // CRUD PERSONAJE
    @GetMapping("/")
    public List<Personaje> obtenerPersonaje(){
        return  persoanjeService.getAll();
    }

    @GetMapping("/{id}")
    public Personaje obtener(@PathVariable Long id){
        return persoanjeService.getByID(id);
    }

    @PutMapping("/{id}")
    public  Personaje actualizar(@PathVariable Long id, @RequestBody Personaje personajeActualizar){
        personajeActualizar.setPersonaje_id(id);
        return  persoanjeService.setItem(personajeActualizar);
    }

    @PostMapping
    public Personaje guardar(@RequestBody Personaje usuarioGuardar){
        return  persoanjeService.setItem(usuarioGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        persoanjeService.deleteByID(id);
    }


    //Conversor Lista
    public static List<PersonajeDTO> conversorListaPersonajeDTO(List<Personaje> l){
        return l.stream().map(PersonajeController::conversorPersonajeDTO).toList();
    }


    //Conversor Unico DTO
    public static PersonajeDTO conversorPersonajeDTO( Personaje p){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        return  personajeDTO;
    }

}
