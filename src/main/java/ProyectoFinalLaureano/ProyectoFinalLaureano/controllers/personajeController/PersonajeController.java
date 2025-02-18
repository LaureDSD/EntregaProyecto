package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController.EstadisticasController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.habilidadController.HabilidadController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.misionController.MisionController;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.habilidades.PersonajeHabilidad;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.misiones.PersonajeMision;
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
    public List<PersonajeDTO> obtenerPersonaje(){
        return  conversorListaPersonajeDTO(persoanjeService.getAll());
    }

    @GetMapping("/{id}")
    public PersonajeDTO obtener(@PathVariable Long id){
        return conversorPersonajeDTO(persoanjeService.getByID(id));
    }

    @PutMapping("/{id}")
    public  PersonajeDTO actualizar(@PathVariable Long id, @RequestBody Personaje personajeActualizar){
        personajeActualizar.setPersonaje_id(id);
        return  conversorPersonajeDTO(persoanjeService.setItem(personajeActualizar));
    }

    @PostMapping
    public PersonajeDTO guardar(@RequestBody Personaje usuarioGuardar){
        return  conversorPersonajeDTO(persoanjeService.setItem(usuarioGuardar));
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
        personajeDTO.setId(p.getPersonaje_id());
        personajeDTO.setImagen(p.getImagen_modelo());
        personajeDTO.setNombre(p.getNombre());
        personajeDTO.setCreacion(p.getFecha_creacion());
        personajeDTO.setClase(p.getClase_persoanje());
        personajeDTO.setNivel(p.getNivel());
        personajeDTO.setXp_acumulada(p.getXp_acumulada());
        personajeDTO.setAlmas(p.getAlmas());
        personajeDTO.setLogros(p.getLogros());
        personajeDTO.setCapacidad_inventario(p.getCapacidad_inventario());
        personajeDTO.setInventario(InventarioController.conversorListaInventarioDTO(p.getInventario()));
        personajeDTO.setEstadisticas(p.getEstadisticas());
        return personajeDTO;
    }


}
